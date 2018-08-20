package cn.nb.controller;

import cn.nb.bean.Product;
import cn.nb.bean.Sale;
import cn.nb.bean.SaleDetail;
import cn.nb.bean.Users;
import cn.nb.service.ProductService;
import cn.nb.service.SaleDetailService;
import cn.nb.service.SaleService;
import cn.nb.service.UserService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController {

    @Resource(name="userService")
    private UserService userService;
    @Resource(name="productService")
    private ProductService productService;
    @Resource(name = "saleService")
    private SaleService saleService;
    @Resource(name="saleDetailService")
    private SaleDetailService saleDetailService;

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public ModelAndView login(Users users,HttpServletRequest request){

        System.out.println("UserController=====>login");
        boolean con =false;
        System.out.println(users);

        ModelAndView mv = new ModelAndView("/WEB-INF/main.jsp");
        //后台
        Users loginUser = userService.findUserByNamePwd(users.getUserName(), users.getPassword());
        //将用户的id保存到session作用域中
        int id = loginUser.getId();
        request.getSession().setAttribute("id",id);
        System.out.println(id);

        System.out.println(loginUser);
        //判断用户是否存在
        if(loginUser==null){
            con=true;
            mv.addObject("con",con);
            mv.setViewName("/index.jsp");
            }else{
            mv.addObject("loginUser",loginUser);
            mv.setViewName("/WEB-INF/main.jsp");
        }
            return mv;
        }


    //用户退出的操作
    @RequestMapping(value = "/exit")
    public ModelAndView login(){


        ModelAndView mv = new ModelAndView("/WEB-INF/main.jsp");
        //后台

         return  mv;

    }
    //显示商品列表
    @RequestMapping(value = "/product")
    public ModelAndView showProduct(){
        System.out.println("UserController=====>showProduct");
        ModelAndView mv = new ModelAndView("/WEB-INF/sale.jsp");
        List<Product> allProduct = productService.findAllProduct();
        mv.addObject("allProduct",allProduct);

        return  mv;

    }
    //向数据表中添加销售信息
    @RequestMapping(value = "/sale")
    public ModelAndView  addProduct(Sale sale,HttpServletRequest request, HttpServletResponse response){
        System.out.println("UserController=====>addProduct");
        //获取系统当前时间
        Date date=new Date();
        /*SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        String format = sdf.format(date);*/
        //获取用户名的id
        int id = (Integer)request.getSession().getAttribute("id");
        System.out.println(id);
        ModelAndView mv = new ModelAndView("/WEB-INF/sale.jsp");
        String goodsName = request.getParameter("goodsName");
        String salePrice= request.getParameter("salePrice");
        String saleNum = request.getParameter("saleNum");
        System.out.println(saleNum);
        sale.setPrice(Double.parseDouble(salePrice));
        sale.setQuantity(Integer.parseInt(saleNum));
        sale.setSaleDate(date);
        //为总价赋值
        double totalPrice=Double.parseDouble(salePrice)*Integer.parseInt(saleNum);
        System.out.println(totalPrice);
        sale.setTotalPrice(totalPrice);
        sale.setUserid(id);

        saleService.addOrder(sale);//添加订单

        boolean flag=false;//定义变量,看看库存有没有减少
        mv.addObject("flag",flag);
        int productId = productService.findIdByProductName(goodsName);
        System.out.println(productId);
        int quantityBefore = productService.findQuantity(productId);//数据库中的库存量==原来的
        //买完货之后更新数据库的库存量
        System.out.println(Integer.parseInt(saleNum));
       productService.updateQuantity(Integer.parseInt(saleNum),productId);
        int quantityAfter=0;
       try{
           quantityAfter=  productService.findQuantity(productId);
       }catch (Exception ex){
           ex.printStackTrace();
       }
        if(quantityBefore==quantityAfter){
            flag=true;
            mv.setViewName("/WEB-INF/sale.jsp");
            mv.addObject("flag",flag);
        }else{
            flag=false;
            mv.setViewName("/WEB-INF/sale.jsp");
            mv.addObject("flag",flag);
        }
       return mv;


    }


    /*销售信息的查询*/
    @RequestMapping("/saleDetail")
    @ResponseBody   //将pageinfo转换成json类型的数据
    public PageInfo showDetail(Integer pageNum){
        System.out.println(pageNum);
        pageNum=pageNum==null?0:pageNum;
        System.out.println("UserController=====>showDetail");
        List<SaleDetail> allSaleDetail1 = saleDetailService.findAllSaleDetail(pageNum, 2);
        System.out.println(allSaleDetail1);
        //创建对象
        PageInfo pageInfo=new PageInfo();
        //获取总的记录条数
        int count = saleDetailService.findCount();
        //补全属性

        pageInfo.setTotal(count);
        pageInfo.setPageSize(2);
        pageInfo.setPageNum(pageNum);
        pageInfo.setList(allSaleDetail1);

        //调用后台的方法

        ModelAndView mv=new ModelAndView("/WEB-INF/detail.jsp");
        List<SaleDetail> allSaleDetail = saleDetailService.findAllSaleDetail(pageNum,pageInfo.getPageSize());

        pageInfo.setList(allSaleDetail);
        System.out.println(pageNum);
        return pageInfo;

    }


    //从main页面跳转到detail.jsp页面 中间步骤
    @RequestMapping("/detail")
    public ModelAndView tiaozhuan(){
        ModelAndView mv=new ModelAndView("/WEB-INF/detail.jsp");
        return mv;
    }



//查看商品的库存量
    @RequestMapping("/stock")
    public ModelAndView findStock(HttpServletRequest request){
        int id = (Integer)request.getSession().getAttribute("id");
        ModelAndView mv=new ModelAndView("/WEB-INF/stock.jsp");

        List<Product> allProduct = productService.findAllProduct();
        //查询库存量
        int quantity = productService.findQuantity(id);
        mv.addObject("allProduct",allProduct);
         mv.addObject("quantity",quantity);

        return mv;
    }

}
