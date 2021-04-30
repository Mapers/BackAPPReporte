package com.cloudsrcsoft.reportes.repository.mybatis.spec;

import org.apache.ibatis.annotations.Select;

public interface ReportMapper {
	@Select("select 'test' from dual")
	String getReportTest();

}
