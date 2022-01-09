package com.star.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.star.entity.Custom;
import com.star.entity.Provider;
import com.star.entity.Stock;
import com.star.mapper.CustomMapper;
import com.star.mapper.ProviderMapper;
import com.star.mapper.StockMapper;


@Controller
public class ProviderController {

	@Autowired
	private ProviderMapper pm;
	@Autowired
	private CustomMapper cm;
	@Autowired
	private StockMapper sm;
	
	@RequestMapping("/ProviderList")
	public String findAllProvider(HttpServletRequest request) {
		List<Provider> listpv = pm.findAll();
		request.setAttribute("list", listpv);
		return "/providerList";
	}
	@RequestMapping("/ProviderModify")
	public String ProviderModify(HttpServletRequest request) {
		String id=request.getParameter("id");
		String flag=request.getParameter("flag");
		// ��ȡ�ж����name��ֵ
		String act=request.getParameter("act");
		
		//���Գ�ʼֵ
		/* System.out.println("��ʼid:"+id);
		System.out.println("��ʼact:"+act);
		System.out.println("��ʼflag:"+flag);*/
		List<Custom> list=cm.selectCustomByType(2);
		//����
		request.setAttribute("providers", list);
		//��ȡ�ɹ�������Ϣ
		List<Stock> list1=sm.findAll();
		//����
		request.setAttribute("providerss", list1);	
		//ɾ��
		if (flag!=null) {
			//���ø���idɾ���ķ���
			pm.deleteProvider(id);
			// ת��
			return "redirect:/ProviderList";
		}
			//�ж�(�ǵ���ı��滹������)
			if (act==null) {
				
				if (id==null) {
					//���
				} else {
					//�޸�
					Provider p=pm.findById(id);
					request.setAttribute("provider", p);
				}
				//ת�����༭����
				return "providerForm";
			}else {
				
				//��ȡ����ʱ���ݵ�����
				String pbid=request.getParameter("pbid");
				String cid=request.getParameter("cid");
				String sid=request.getParameter("sid");
				String date=request.getParameter("date");
				double totalprice=Double.parseDouble(request.getParameter("totalprice"));
				//ʵ����Provider
				Provider p=new Provider();
				p.setPbid(pbid);
				Custom ce=new Custom();
				ce.setCid(cid);
				p.setCustom(ce);
				Stock s=new Stock();
				s.setSid(sid);
				p.setStock(s);
				p.setDate(date);
				p.setTotalprice(totalprice);
				
				//���� ���
				if ("add".equals(act)) {
					//������ӵķ���
					pm.insert(p);
				} else if("mdy".equals(act)) {
					//�����޸ĵķ���
					pm.updateProvider(p);
				}
				
				//ת������ѯ���вɹ��˻��ĵ�ַ
				return "redirect:/ProviderList";
			}
		}
}
	

