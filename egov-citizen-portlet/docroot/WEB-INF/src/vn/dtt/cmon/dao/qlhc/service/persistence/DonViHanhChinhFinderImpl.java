package vn.dtt.cmon.dao.qlhc.service.persistence;


import java.util.List;

import vn.dtt.cmon.dao.qlhc.model.DonViHanhChinh;


import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;

import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

public class DonViHanhChinhFinderImpl extends BasePersistenceImpl<DonViHanhChinh> implements DonViHanhChinhFinder {
	
  public	java.util.List<vn.dtt.cmon.dao.qlhc.model.DonViHanhChinh> dsTinhThanh(){
	  
		Session session = null;
		StringBuffer sql = new StringBuffer();
		
		try {
			session = openSession();
			sql.append("SELECT d from DonViHanhChinh d ");
			sql.append(" WHERE d.chaId is null AND d.daXoa=0");
			
			sql.append(" ORDER BY d.ten ASC ");
			
			Query q = session.createQuery(sql.toString());
			//q.addEntity("DocumentType", DocumentType.class);
			QueryPos qPos = QueryPos.getInstance(q);
						
			
			List<DonViHanhChinh> list = (List<DonViHanhChinh>)QueryUtil.list(q, getDialect(),QueryUtil.ALL_POS, QueryUtil.ALL_POS, false);
			return list;
				
		
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			
			closeSession(session);
		}
		
		return null;
	

	}

}
