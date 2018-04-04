package standard.dao;

import java.util.List;

import standard.entity.Standard;

public interface StandarDao {
	
	List<Standard> getAll();
	
	List<Standard> getStan(String title,int pageNumb,int pageSize);
	
	void addStandard(Standard standard);
	
	void delete(int id);
	
	int getNum(String title);
	
	Standard fechByid(int id);
	
	void update(Standard standard);

}
