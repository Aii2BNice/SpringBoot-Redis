package com.dyq.contract.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dyq.JumpController;
import com.dyq.contract.domain.Contract;
import com.dyq.contract.service.ContractService;
import com.dyq.file.domain.FileInfo;
import com.dyq.file.service.FileService;
import com.dyq.user.domain.Login;
import com.dyq.user.service.UserService;

@Controller
public class ContractController {
	
	@Autowired 
	private ContractService contractService;
	@Autowired
	private UserService userService;
	@Autowired
	private FileService fileService;
	
	// 查询所有签订合同
	@RequestMapping("queryAllContract")
	public String queryAllContract(HttpServletRequest req,Contract contract,String loginName) {
		Login user = userService.queryLoginByName(loginName);
		contract.setUser(user);
		req.setAttribute("contracts", contractService.queryAllContract(contract));
		return JumpController.getJumpUrl("queryContract", user.getPowerId());
	} 
	
	//删除合同信息
	@RequestMapping("deleteContract")
	public String deleteContract(HttpServletRequest req,Integer contractId) {
		contractService.deleteContract(contractId);
		req.setAttribute("msg", "合同删除成功");
		return "/system/contract/querycontract";
	}
	
	//合同签订跳转
	@RequestMapping("toInsContract")
	public String toInsContract(HttpServletRequest req,String loginName,Integer fileId) {
		Login user = userService.queryLoginByName(loginName);
		FileInfo file = fileService.queryFileById(fileId);
		req.setAttribute("customerId", user.getLoginId());
		req.setAttribute("file", file);
		return "/customer/insContract";
	}
	
}
