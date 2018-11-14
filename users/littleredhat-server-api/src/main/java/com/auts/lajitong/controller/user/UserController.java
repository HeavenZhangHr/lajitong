package com.auts.lajitong.controller.user;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.auts.lajitong.consts.Const;
import com.auts.lajitong.controller.SBaseController;
import com.auts.lajitong.model.common.PhiHomeBaseResponse;
import com.auts.lajitong.service.UserService;
import com.auts.lajitong.util.StringUtil;

/**
 * 用户个人信息接口.
 *
 * rongwei.huang
 *
 */
@RestController
@CrossOrigin
public class UserController extends SBaseController {
    private static final Logger LOGGER = LogManager.getLogger(UserController.class);

    public static final String DEFAULT_CHARSET = "utf-8";
    public static String HTTP_HEAD_AUTHORIZATION = "Authorization";
    public static String HTTP_HEAD_CONTENT_TYPE = "Content-Type";

    @Autowired
    private UserService userService;

    /**
     * 修改个人信息.
     * @param request
     * @return
     */
    @RequestMapping(value = "/users/v1/modify", method = RequestMethod.POST, produces = { "application/json" })
    public PhiHomeBaseResponse queryAllInfoCount(HttpServletRequest request,
            @RequestParam(value = "id", required = true) String id,
            @RequestParam(value = "nickName", required = false) String nickName,
            @RequestParam(value = "sex", required = false) String sex) {
        PhiHomeBaseResponse rspObj = new PhiHomeBaseResponse();

        if (nickName == null && sex == null) {
          //不用更新
            return successResponse(rspObj);
        }else if (nickName == null) {
            //只更新sex
            if (Const.SexType.SEX_MAIL_STR.equals(sex) || Const.SexType.SEX_FEMAIL_STR.equals(sex)) {
                int sexInt = Integer.parseInt(sex);
                userService.updateUserSex(id, sexInt);
            }
        }else if(sex == null){
            //只更新nickName
            userService.updateUserNickName(id, nickName);
        }else {
            //更新两个
            if (Const.SexType.SEX_MAIL_STR.equals(sex) || Const.SexType.SEX_FEMAIL_STR.equals(sex)) {
                int sexInt = Integer.parseInt(sex);
                userService.updateUser(id, nickName, sexInt);
            }
        }
        return successResponse(rspObj);
    }
}
