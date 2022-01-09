package com.star.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.star.entity.Provider;

@Repository("providerMapper")
public interface ProviderMapper {
		public List<Provider> findAll();
		public Provider findById(@Param("pbid") String pbid);
		public int updateProvider(Provider pv);
		public int insert (Provider pv);
		public int deleteProvider (@Param("pbid") String pbid);
}
