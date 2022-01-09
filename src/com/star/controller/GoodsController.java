package com.star.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;





import com.star.entity.Goods;
import com.star.entity.GoodsType;
import com.star.mapper.GoodsMapper;
import com.star.mapper.GoodsTypeMapper;


@Controller
public class GoodsController {
	@Autowired
	private GoodsMapper gm;
	@Autowired
	private GoodsTypeMapper gtm;
	
	@RequestMapping("/GoodsList")
	public String findAllGoods(HttpServletRequest request) {
		List<Goods> listGM = gm.findAll();
		request.setAttribute("list", listGM);
		return "/goodsList";
	}
	
	@RequestMapping("/GoodsModify")
	public String GoodsModefy(HttpServletRequest request) {
		//��ȡ����ʱ�Ĳ���
		String act = request.getParameter("act");
		//��ȡ��������� �޸�(id) ɾ��(id,flag)
		String id = request.getParameter("id");
		String flag = request.getParameter("flag");		
		//�ж�(�ǵ���ı��滹��������(act�Ǳ���))
		if (act == null) {	
			//���
			//��ѯ��Ʒ���
			List<GoodsType> list=gtm.findAll();
			//����
			request.setAttribute("type", list);	
			//�ж�(��ʱ������ɾ�����Ǳ༭)
			if ("d".equals(flag)) {
			    //ɾ��(���ø���idɾ���ķ���)
				gm.deleteGoods(id);
				return "redirect:/GoodsList";	
			} else {
				if (id == null) {
					//���
				} else {
					//�޸�
					Goods g = gm.getGoodsById(id);
					request.setAttribute("goods", g);
				}		
				//ת�����༭����
				return "goodsForm";
			}
			
		}	 else {
			
			//����
			//��ȡ�������ʱ�Ĳ���
			String tid=request.getParameter("tid");
			String gid=request.getParameter("gid");
			String name=request.getParameter("name");
			String unit=request.getParameter("unit");
			//ǿ��ת��
			double pin=Double.parseDouble(request.getParameter("pin"));
			double pout=Double.parseDouble(request.getParameter("pout"));
			int amount=Integer.parseInt(request.getParameter("amount"));
			//��������
			Goods g=new Goods();
			g.setGid(gid);
			//��װ����
			GoodsType gt1=new GoodsType();
			gt1.setTid(tid);
			g.setGoodType(gt1);
			g.setName(name);
			g.setUnit(unit);
			g.setPin(pin);
			g.setPout(pout);
			g.setAmount(amount);
			
			if ("add".equals(act)) {
				//������ӵķ���
				int i = gm.addGoods(g);
						
			} else if ("mdy".equals(act)) {
				//����ʱ���޸�(�����޸ĵķ���)
				int i = gm.updateGoods(g);
				
			}
			//ת������ѯ������Ʒ��Ϣ�ĵ�ַ
			return "redirect:/GoodsList";
		}		

	}
	@RequestMapping("/GoodsModifys")
	public String GoodsModefies(HttpServletRequest request) {
		//��ȡ�������ʱ�Ĳ���
				String tid=request.getParameter("tid");
				String gid=request.getParameter("gid");
				String name=request.getParameter("name");
				String unit=request.getParameter("unit");
				//ǿ��ת��
				double pin=Double.parseDouble(request.getParameter("pin"));
				double pout=Double.parseDouble(request.getParameter("pout"));
				int amount=Integer.parseInt(request.getParameter("amount"));
				//��������
				Goods g=new Goods();
				g.setGid(gid);
				//��װ����
				GoodsType gt1=new GoodsType();
				gt1.setTid(tid);
				g.setGoodType(gt1);
				g.setName(name);
				g.setUnit(unit);
				g.setPin(pin);
				g.setPout(pout);
				g.setAmount(amount);
			
				//������������(addGoods��dao���е���������)
				int ag=gm.addGoods(g);

				//����ӵĽ���
				//�������²�ѯ��������servlet������в���ֱ����ת��������GoodsList ���²�ѯ��
				return "redirect:/GoodsList";
	}
}

		
	
		