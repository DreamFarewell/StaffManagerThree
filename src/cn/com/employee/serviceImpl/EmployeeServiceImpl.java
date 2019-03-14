package cn.com.employee.serviceImpl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import cn.com.employee.mapper.EmployeeinformationMapper;
import cn.com.employee.mapper.EmployeeinformationMapperCustom;
import cn.com.employee.page.Page;
import cn.com.employee.po.Employeeinformation;
import cn.com.employee.po.EmployeeinformationCustom;
import cn.com.employee.po.EmployeeinformationQueryVo;
import cn.com.employee.service.EmployeeService;

/**
 * service实现类
 * 
 * @author 胡金光
 *
 */
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	private EmployeeinformationMapper employeeinformationMapper;
	@Autowired
	private EmployeeinformationMapperCustom employeeinformationMapperCustom;
	/**
	 * @author 胡金光 添加员工信息
	 */
	@Override
	public void addEmployee(EmployeeinformationCustom employeeinformationCustom) throws Exception {
		if (employeeinformationCustom.getName() != null && employeeinformationCustom.getAge() != null
				&& employeeinformationCustom.getSex() != null) {
			employeeinformationMapper.insert(employeeinformationCustom);
		}
	}

	/**
	 * @author 胡金光 根据员工号查询员工信息
	 */
	@Override
	public EmployeeinformationCustom selectById(Integer id) throws Exception {
		EmployeeinformationCustom employeeinformationCustom = null;
		if (id != null) {
			Employeeinformation employeeinformation = employeeinformationMapper.selectByPrimaryKey(id);
			if (employeeinformation != null) {
				employeeinformationCustom = new EmployeeinformationCustom();
				BeanUtils.copyProperties(employeeinformation, employeeinformationCustom);
			}
		}
		return employeeinformationCustom;
	}
	/**
	 * @author 胡金光 按照员工姓名查找员工列表
	 */
	@Override
	public List<EmployeeinformationCustom> selectEmployeeList(EmployeeinformationQueryVo employeeinformationQueryVo)
			throws Exception {
		return employeeinformationMapperCustom.findStaff(employeeinformationQueryVo);
	}

	/**
	 * @author 胡金光 根据员工号更新员工信息
	 */
	@Override
	public void updateEmployee(Integer id, EmployeeinformationCustom employeeinformationCustom) throws Exception {
		if (id != null && employeeinformationCustom.getAge() != null && employeeinformationCustom.getName() != null
				&& employeeinformationCustom.getSex() != null) {
			employeeinformationCustom.setId(id);
			employeeinformationMapper.updateByPrimaryKey(employeeinformationCustom);
		}
	}

	/**
	 * 删除员工
	 */
	@Override
	public void deleteEmployee(Integer id) throws Exception {
		if (id != null) {
			employeeinformationMapper.deleteByPrimaryKey(id);
		}
	}
	
	/**
	 * 批量删除
	 */
	@Override
	public void batchDeleteEmployee(Integer[] id) throws Exception {
			employeeinformationMapperCustom.batchDeleteEmployee(id);
	}
	/**
	 * 批量更新
	 */
	@Override
	public void batchUpdateEmployee(EmployeeinformationQueryVo employeeinformationQueryVo) throws Exception {
			employeeinformationMapperCustom.batchUpdateEmployee(employeeinformationQueryVo);
	}
	/**
	 * 批量更新前查询
	 */
	@Override
	public List<EmployeeinformationCustom> batchFindUpdate(Integer[] id) throws Exception {
		return employeeinformationMapperCustom.batchFindUpdate(id);
	}
	/**
	 * 分页操作
	 */
	@Override
	public Page<EmployeeinformationCustom> getPage(int pageNumber) throws Exception {
		int pageNo=1;//设置默认页码，当pageNumber类型转换出错时，会起作用，否则值被覆盖
		Page<EmployeeinformationCustom> page =null;
		pageNo=pageNumber;
		//获取总记录数
		int totalRecord=employeeinformationMapperCustom.getRecordsCount();
		page=new Page<EmployeeinformationCustom> (pageNo,totalRecord);
		List<EmployeeinformationCustom> list = employeeinformationMapperCustom.pageList(page.getIndex(), page.getPageSize());
		page.setList(list);
		return page;
	}
}