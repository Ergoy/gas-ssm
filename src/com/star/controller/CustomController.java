package com.star.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.star.entity.Custom;
import com.star.mapper.CustomMapper;



@Controller
public class CustomController {

	@Autowired
	private CustomMapper cm;
	
	
	@RequestMapping("/CustList")
	public String findAllCustom(HttpServletRequest request) {
		int type=Integer.parseInt(request.getParameter("type"));
		List<Custom> listCM = cm.selectCustomByType(type);
		//�������ݵ�request
		//request.setAttribute("type", String.valueOf(type));
		request.setAttribute("type", type);
		request.setAttribute("list", listCM);
		return "/custList";
	}
	
	@RequestMapping("/CustModify")
	public String AddCustom(HttpServletRequest request) {
		String type = request.getParameter("type");
		String id = request.getParameter("id");
		String flag = request.getParameter("flag");
		//��ȡ����ʱ�Ĳ���
		String act = request.getParameter("act");
		request.setAttribute("type", type);
		//�ж�(�ǵ���ı��滹��������(act�����Ǳ���))
		if (act == null) {
			
			//�ж�(��ʱ���޸�ɾ�����Ǳ༭)
			if ("d".equals(flag)) {
				//ɾ��(���ø���idɾ���ķ���)
				cm.deleteCustom(id);
				//���²�ѯ
				if ("1".equals(type)) {
					return "redirect:/CustList?type=1";
				} else {
					return "redirect:/CustList?type=2";	
				}
			} else {
				if (id == null) {
					//���(ת������ӽ���)
				} else {
					//�޸�
					Custom ct = cm.selectCustomById(id);
					request.setAttribute("ct", ct);
				}
				//ת�����༭����
				return "custForm";
			}

		}else {
			
			//��ȡ����ʱ���ݵ�����
			String cid = request.getParameter("cid");
			String name = request.getParameter("name");
			String linkman = request.getParameter("linkman");
			String addr = request.getParameter("addr");
			String tel = request.getParameter("tel");
			String email = request.getParameter("email");
			String remark = request.getParameter("remark");
			//�������� ����ֵ
			Custom ct = new Custom();
			ct.setCid(cid);
			ct.setName(name);
			ct.setLinkman(linkman);
			ct.setAddr(addr);
			ct.setTel(tel);
			ct.setEmail(email);
			ct.setRemark(remark);
			
			//���� ���
			if ("add".equals(act)) {
				int at = Integer.parseInt(request.getParameter("type"));
				ct.setType(at);
				//������ӵķ���
				int i = cm.addCustom(ct);
				
			} else if ("mdy".equals(act)) {
				//����ʱ���޸�
				//�����޸ĵķ���
				int i = cm.updateCustom(ct);
			}
			
			//ת������ѯ���пͻ���Ϣ�ĵ�ַ
			return "redirect:/CustList?type="+type;	
			
		}
		
	}
}



