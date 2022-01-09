package com.star.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.star.entity.Goods;
import com.star.entity.Provider;
import com.star.entity.ProviderBack;
import com.star.mapper.GoodsMapper;
import com.star.mapper.ProviderBackMapper;
import com.star.mapper.ProviderMapper;



@Controller
public class ProviderBackController {
	
	@Autowired
	private ProviderBackMapper pbm;
	@Autowired
	private ProviderMapper pm;
	@Autowired
	private GoodsMapper gm;
	
	@RequestMapping("/ProviderBackList")
	public String findAllProviderBack(HttpServletRequest request) {
		String id=request.getParameter("id");
		List<ProviderBack> pb=pbm.fandAll(id);
		//����(�Ѽ��ϴ洢��request)
		request.setAttribute("list", pb);
		//ת��(��ת��providerBackList.jsp����)
		return "providerBackList";
	}
	@RequestMapping("/ProviderBackModify")
	public String ProviderBackModify(HttpServletRequest request) {
		//��ȡ����
				String id=request.getParameter("id");
				String flag=request.getParameter("flag");
				// ��ȡ�ж����name��ֵ
				String act=request.getParameter("act");
				// ��ȡ���²�ѯid(ɾ��)
				String pbid=request.getParameter("pbid");
				
				//��������
				/* System.out.println("��ʼact:"+act);
				System.out.println("��ʼid:"+id);
				System.out.println("���pbid:"+pbid);
				System.out.println("flag:"+flag); */
				
				//��ȡ���������������
				//��һ��
				List<Provider> list=pm.findAll();
				request.setAttribute("backs",list);
				//�ڶ���
				List<Goods> lis=gm.findAll();
				request.setAttribute("good", lis);
				//ɾ��
				if (flag!=null) {
					//���ø���idɾ���ķ���
					pbm.deleteProvider_back(id);
					List<ProviderBack> pb=pbm.fandAll(pbid);
					request.setAttribute("list", pb);
					//ת��
					return "providerBackList";
				}
				
				//�ж�(�ǵ���ı��滹������)
				if (act==null) {
					
					if (id==null) {
						//����
					} else {
						//�޸�
						ProviderBack pb=pbm.findById(id);
						request.setAttribute("back", pb);
					}
					//ת�����༭����
					return "providerBackForm";
				
				} else {
					
					//��ȡ����ʱ���ݵ�����
					String pbdid=request.getParameter("pbdid");
					String gid=request.getParameter("gid");
					double price=Double.parseDouble(request.getParameter("price")) ;
					int amount=Integer.parseInt(request.getParameter("amount")) ;
					//ʵ����ProviderBack
					ProviderBack pb=new ProviderBack();
					pb.setPbdid(pbdid);
					//ʵ����Provider
					Provider p=new Provider();
					p.setPbid(pbid);
					pb.setProvider(p);
					//ʵ����Goods
					Goods g=new Goods();
					g.setGid(gid);
					pb.setGoods(g);
					pb.setPrice(price);
					pb.setAmount(amount);
					
					//���� ���
					if("add".equals(act)) {
						//������ӵķ���
						pbm.insert(pb);
					}else if("mdy".equals(act)){
						//�����޸ĵķ���
						pbm.updateProvider_back(pb);
					}
					
					List<ProviderBack> pbs=pbm.fandAll(pbid);
					request.setAttribute("list", pbs);
					//ת������ѯ�ĵ�ַ
					return "providerBackList";
				}
	}

}
