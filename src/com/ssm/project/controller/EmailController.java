package com.ssm.project.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.ssm.project.model.Email;
import com.ssm.project.model.User;
import com.ssm.project.service.EmailService;
import com.ssm.project.service.UserService;

@Controller
@RequestMapping("/email")
public class EmailController {
	@Autowired
	private EmailService emailService;
	@Autowired
	private UserService userService;

	/**
	 * 写邮件
	 */
	@RequestMapping(value = ("/write.do"))
	@ResponseBody
	public List<User> write(String uName) {
		return userService.findByName(uName);
	}

	/**
	 *  保存邮件
	 * @param email
	 * @return
	 */
	@RequestMapping(value = "/save.do")
	@ResponseBody 
	public Map<String,String> save(Email email) {
		email.seteReceivetime(new Date());
		Map<String,String> map = new HashMap<String,String>();
		try {
			emailService.save(email);
			map.put("message", "保存成功");
		} catch (Exception e) {
			map.put("message", "保存失败");
		}
		return map;
	}

	/**
	 * 上传图片
	 * @param pic
	 * @param request
	 * @return
	 * @throws IOException 
	 * @throws IllegalStateException 
	 */
	@RequestMapping(value = "/uploadPic.do")
	@ResponseBody
	public Map<String,String> uploadPic(@RequestParam CommonsMultipartFile pic,HttpServletRequest request) throws IllegalStateException, IOException{
		//获取文件真实名称
		//String name = pic.getOriginalFilename();
		//System.out.println(filename);
		//年月日分时秒 （毫秒） + 随机数（三位）
		DateFormat df = new SimpleDateFormat("yyyyMMddHHmmssSSS");
		//图片名
		String name = df.format(new Date());
		
		Random r = new Random();
		for (int i = 0; i < 3; i++) {
			name += r.nextInt(10);
		}
		//一款可以获取扩展名
		String ext = FilenameUtils.getExtension(pic.getOriginalFilename());
		
		//1 返回相对路径
		String fileName = name + "." + ext; //png
		//给请求路径 URL
		//2
		//绝对路径，用于保存图片
		String absolutePath = request.getSession().getServletContext().getRealPath("/download/");
		//相对路径，用于显示图片
		String relativePath = request.getContextPath()+File.separator+"download"+File.separator;
		String url = relativePath + fileName;
		File targetFile = new File(absolutePath, fileName);
		if (!targetFile.exists()) {
			targetFile.mkdirs();
		}
		//file.getFileItem().write(targetFile); //将上传的文件写入新建的文件中
		pic.transferTo(targetFile);
		//返回  path url 
		Map<String,String> map = new HashMap<String,String>();
		map.put("path", fileName);
		map.put("url", url);
		return map;
	}
		
	/**
	 * 下载邮件(注意修改tomcat下的server.xml乱码问题)
	 * @throws IOException 
	 */
	@RequestMapping(value = ("/download.do"), method = { RequestMethod.POST, RequestMethod.GET })
	public String download(@RequestParam String fileName, HttpServletResponse response,HttpServletRequest request) throws IOException {
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		String ctxPath = request.getSession().getServletContext().getRealPath("/download/")+File.separator; //获取本地存储路径 "/download/";
		String downLoadPath = ctxPath + fileName;
		try {
			long fileLength = new File(downLoadPath).length();
			response.reset();
			response.setContentType("application/x-msdownload;");
			response.setHeader("Content-disposition", "attachment; filename=" + new String(fileName.getBytes("utf-8"), "ISO-8859-1"));
			response.setHeader("Content-Length", String.valueOf(fileLength));
			bis = new BufferedInputStream(new FileInputStream(downLoadPath));
			bos = new BufferedOutputStream(response.getOutputStream());
			byte[] buff = new byte[2048];
			int bytesRead;
			while (-1 != (bytesRead = bis.read(buff, 0, buff.length))) {
				bos.write(buff, 0, bytesRead);
			}
		} catch (Exception e) {
			e.getMessage();
		} finally {
			if (bis != null)
				bis.close();
			if (bos != null)
				bos.close();
		}
		return null;
	}

	/**
	 * 详情
	 */
	@RequestMapping(value = ("/detail.do"))
	public String detail(HttpServletRequest request, String eId) {
		Email email = emailService.findDetail(eId);
		if (email != null) {
			request.setAttribute("email", email);
			return "/jsp/email/details";
		}
		return "redirect:/error.jsp";
	}

	/**
	 * 已读
	 */
	@RequestMapping(value = ("/update.do"))
	public String update(String eId) {
		if (emailService.update(eId)) {
			return "jsp/email/receive";
		}
		return "redirect:/error.jsp";
	}

	/**
	 * 收件箱
	 */
	@RequestMapping(value = ("/reveive.do"))
	@ResponseBody
	public Map<String,Object> list(String eReceive,Integer page,Integer rows) {
		Map<String,Object>	map = emailService.findReceive(page, rows, eReceive);
		return map;
	}

	/**
	 *	逻辑删除
	 * @throws IOException 
	 */
	@RequestMapping(value = ("/deleteVirtual.do"))
	@ResponseBody
	public Map<String,Object> deleteVirtual(String eId) {
		Map<String,Object> map = new HashMap<String,Object>(); 
		try {
			if (emailService.deleteVirtual(eId)) {
				map.put("message", "操作成功！");
			}
		} catch (Exception e) {
			map.put("message", "操作失败！");
		}
		return map;
	}

	/**
	 * 回收站
	 */
	@RequestMapping(value = ("/recycle.do"))
	@ResponseBody
	public Map<String,Object> recycle(String eReceive,Integer page,Integer rows) {
		Map<String,Object>	map = emailService.findRecycle(page, rows, eReceive);
		return map;
	}

	/**
	 * 物理删除
	 */
	@RequestMapping(value = ("/delete.do"))
	@ResponseBody
	public Map<String,Object> delete(String eId) {
		Map<String,Object> map = new HashMap<String,Object>(); 
		try {
			if (emailService.delete(eId)) {
				map.put("message", "操作成功！");
			}
		} catch (Exception e) {
			map.put("message", "操作失败！");
		}
		return map;
	}

	/**
	 * 还原
	 */
	@RequestMapping(value = ("/reduction.do"))
	@ResponseBody
	public Map<String,Object> reduction(String eId) {
		Map<String,Object> map = new HashMap<String,Object>(); 
		try {
			if (emailService.updateReduction(eId)) {
				map.put("message", "操作成功！");
			}
		} catch (Exception e) {
			map.put("message", "操作失败！");
		}
		return map;
	}
}
