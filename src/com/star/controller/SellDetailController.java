package com.star.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.star.entity.Goods;
import com.star.entity.Sell;
import com.star.entity.SellDetail;
import com.star.mapper.GoodsMapper;
import com.star.mapper.SellDetaiMapper;
import com.star.mapper.SellMapper;


@Controller
public class SellDetailController {
	@Autowired
	private SellDetaiMapper sdm;
	@Autowired
	private SellMapper sm;
	@Autowired
	private GoodsMapper gm;
	
	@RequestMapping("/SellDetailList")
	public String findAllSellD(HttpServletRequest request) {
		//��ѯ��������(SellDetail������)
		//��ȡ��idֵ
		String id= request.getParameter("id");
		List<SellDetail> sd=sdm.findAll(id);
		//����(�Ѽ��ϴ洢��request)
		request.setAttribute("list", sd);
		//ת��(��ת��sellDetailList.jsp����)
		return "sellDetailList";
		
	}
	@RequestMapping("/SellDetailModify")
	public String SellDModify(HttpServletRequest request) {
		String id = request.getParameter("id");
		String flag = request.getParameter("flag");
		// ��ȡ�ж����name��ֵ
		String act = request.getParameter("act");
		// ��ȡ���²�ѯid(ɾ��)
		String ids = request.getParameter("ids");
		List<Sell> list = sm.findAll();
		// ���Գ�ʼֵ
		/* System.out.println("��ʼact:" + act);
		System.out.println("Modify��ʼId:" + id);
		System.out.println("��ʼflag:"+flag); */
		
		// ��ȡ����id
		List<Goods> list2 = gm.findAll();
		// ����
		request.setAttribute("sell", list);
		request.setAttribute("goods", list2);
		// ɾ��
		if (flag != null) {
			//���ø���idɾ���ķ���
			sdm.deleteSellDetail(id);
			List<SellDetail> sd = sdm.findAll(ids);
			request.setAttribute("list", sd);
			// ת��
			return "sellDetailList";
		}
		//�ж�(�ǵ���ı��滹������)
		if (act == null) {
					
			if (id == null) {
				// ���
			} else {
				// �޸�
				SellDetail sd = sdm.findById(id);
				request.setAttribute("detail", sd);
			}
			    //ת�����༭����
				return "sellDetailForm";
		}else {
			
			//��ȡ����ʱ���ݵ�����
			String sdid = request.getParameter("sdid");
			String sid = request.getParameter("sid");
			String gid = request.getParameter("gid");
			int amount = Integer.parseInt(request.getParameter("amount"));
			double price = Double.parseDouble(request.getParameter("price"));
			// ʵ����SellDetail
			SellDetail sd = new SellDetail();
			sd.setSdid(sdid);
			// ʵ����Sell
			Sell s = new Sell();
			s.setSid(sid);
			sd.setSell(s);
			// ʵ����Goods
			Goods g = new Goods();
			g.setGid(gid);
			sd.setGoods(g);
			sd.setAmount(amount);
			sd.setPrice(price);
			
			//���� ���
			if ("add".equals(act)) {
				//������ӵķ���
				sdm.insert(sd);
			} else if ("mdy".equals(act)) {
				//�����޸ĵķ���
				sdm.updateSellDetail(sd);
			}
			
			List<SellDetail> sds = sdm.findAll(sid);
			request.setAttribute("list", sds);
			//ת������ѯ�ĵ�ַ
			return "sellDetailList";
		}
	}

}
