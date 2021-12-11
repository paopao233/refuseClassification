package com.parklot.vo;

import lombok.Data;

/**
 * ClassName UserVo
 * Description TODO
 * Author lezi
 * Date 2021/11/24 22:06
 * Version 1.0
 **/
@Data
public class UserVo {
    private String username;

    private String password;

    private String rePassword;

    private String email;
}
