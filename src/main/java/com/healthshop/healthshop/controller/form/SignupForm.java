package com.healthshop.healthshop.controller.form;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class SignupForm {

    @NotBlank(message = "이름은 필수 입력값입니다.")
    private String name;

    @NotBlank(message = "아이디는 필수 입력값입니다.")
    private String loginId;

    @NotBlank(message = "비밀번호는 필수 입력값입니다.")
    @Pattern(regexp = "(?=.*[0-9])(?=.*[a-zA-Z])(?=.*\\W)(?=\\S+$).{8,16}",
            message = "비밀번호는 숫자, 영문자, 특수문자를 포함한 8~16자리여야 합니다.")
    private String password;

    @Email(message = "유효한 이메일 주소여야 합니다.")
    private String email;

    @Pattern(regexp = "^\\d{11}$|^$", message = "전화번호는 11자리 숫자여야 합니다.")
    private String phone;

}
