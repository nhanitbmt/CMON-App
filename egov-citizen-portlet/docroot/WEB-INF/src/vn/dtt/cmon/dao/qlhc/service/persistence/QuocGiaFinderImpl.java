package vn.dtt.cmon.dao.qlhc.service.persistence;

import java.util.List;

import vn.dtt.cmon.dao.qlhc.model.QuocGia;
import vn.dtt.cmon.dao.qlhc.model.impl.QuocGiaImpl;

import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

public class QuocGiaFinderImpl extends BasePersistenceImpl<QuocGia> implements QuocGiaFinder {
	
	@SuppressWarnings("unchecked")
	public List<QuocGia> findAll() {
		Session session = openSession();
		SQLQuery query = session.createSQLQuery(
			"SELECT * FROM CMON_QUOCGIA QG WHERE QG.DAXOA = 0 ORDER BY NLSSORT(QG.TEN, 'NLS_SORT = BINARY_AI')");
		query.addEntity(QuocGia.class.getSimpleName(), QuocGiaImpl.class);
		List<QuocGia> out = (List<QuocGia>) query.list();
		closeSession(session);
		return out;
	}
}
