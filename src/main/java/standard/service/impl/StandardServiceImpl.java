package standard.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import standard.dao.StandarDao;
import standard.entity.Standard;
import standard.service.ServiceException;
import standard.service.StandardService;

@Service
public class StandardServiceImpl implements StandardService{
	
	@Autowired
	private StandarDao sd;

	@Override
	public List<Standard> getAll() {
		// TODO Auto-generated method stub
		return sd.getAll();
	}

	@Override
	public List<Standard> getStan(String title, int pageNumb, int pageSize) {
		// TODO Auto-generated method stub
		return sd.getStan(title, pageNumb, pageSize);
	}

	@Override
	public void addStandard(Standard standard) {
		// TODO Auto-generated method stub
		sd.addStandard(standard);
	}

	

	@Override
	public int getNum(String title) {
		// TODO Auto-generated method stub
		return sd.getNum(title);
	}

	@Override
	public Standard fechByid(int id) {
		// TODO Auto-generated method stub
		return sd.fechByid(id);
	}

	@Override
	public void delete(int[] id) throws ServiceException {
		// TODO Auto-generated method stub
		try {
			for (int i : id) {
				sd.delete(i);
			}
		} catch (Exception e) {
			// TODO: handle exception
			throw new ServiceException("删除失败");
		}
		
	}

	@Override
	public void update(Standard standard) {
		// TODO Auto-generated method stub
		sd.update(standard);
	}

}
