/*
<script language="javascript">
    function checklogin()
    {
        if((myform.user.value!=""))
        {
            if((myform.pwd.value!=""))
            {
                return true
            }
            else
            {
                alert("密码不能为空");
                return false
            }
        }
        else
        {
            alert("用户名不能为空");
            return false
        }
    }

    </script>*/

function checkLogin() {
    if(myform.userName.value!=""){
        if(myform.password.value!=""){
            return true;

        }else{
            alert("密码必填")
            return false;
        }

    }else{
        alert("用户名必填")
        return false;
    }


}


