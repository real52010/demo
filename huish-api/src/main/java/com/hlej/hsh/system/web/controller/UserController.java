package com.hlej.hsh.system.web.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hlej.hsh.base.common.BaseReturnCode;
import com.hlej.hsh.base.service.BaseResult;
import com.hlej.hsh.base.web.model.BaseResponse;
import com.hlej.hsh.base.web.model.LoginUserInfo;
import com.hlej.hsh.system.service.UserService;
import com.hlej.hsh.system.service.pojo.UserInfoPojo;
import com.hlej.hsh.system.web.reqmodel.LoginRequset;
import com.hlej.hsh.system.web.reqmodel.RegisterRequest;
import com.hlej.hsh.system.web.resmodel.GetUserInfoResponse;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService userService;

	@RequestMapping("/regiester")
	@ResponseBody
	public BaseResponse regiester(@RequestHeader HttpHeaders headers, @RequestBody RegisterRequest user) {
		UserInfoPojo pojo = new UserInfoPojo();
		BeanUtils.copyProperties(user, pojo);
		BaseResult<String> baseresult = userService.registerUser(pojo);
		return new BaseResponse(baseresult.getReturnCode(), baseresult.getReturnMsg());
	}

	@RequestMapping("/login")
	@ResponseBody
	public BaseResponse login(@RequestHeader HttpHeaders headers, @RequestBody LoginRequset user, HttpSession session) {
		UserInfoPojo pojo = new UserInfoPojo();
		BeanUtils.copyProperties(user, pojo);
		BaseResult<String> baseresult = userService.UserLogin(pojo);
		return new BaseResponse(baseresult.getReturnCode(), baseresult.getReturnMsg());
	}

	@RequestMapping("/getuseinfo")
	@ResponseBody
	public BaseResponse getUserInfo(@RequestHeader HttpHeaders headers, LoginUserInfo loginUserinfo,
			HttpSession session) {
		UserInfoPojo pojo = new UserInfoPojo();
		BeanUtils.copyProperties(loginUserinfo, pojo);
		BaseResult<UserInfoPojo> baseresult = userService.getUserInfo(pojo);

		if (baseresult.getData() == null) {
			return new BaseResponse(baseresult.getReturnCode(), baseresult.getReturnMsg());
		}
		UserInfoPojo pojo2 = baseresult.getData();

		GetUserInfoResponse response = new GetUserInfoResponse();
		BeanUtils.copyProperties(pojo2, response);
		response.setReturnCode(BaseReturnCode.SUCCESS);
		return response;
	}

}
