package dev.java.db.daos;

import dev.java.db.model.CVFeedback;
import org.hibernate.Session;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class CVFeedbackDao extends AbstractDao<CVFeedback> {
    public CVFeedbackDao(Session session) {
        super(session);
    }

    @Override
    public List<CVFeedback> getSortedEntitiesPage(int pageNumber, String sortedField,
                                                         boolean order, int itemsNumberInPage) {
        CriteriaBuilder criteriaBuilder = getSession().getCriteriaBuilder();
        CriteriaQuery<CVFeedback> query = criteriaBuilder.createQuery(CVFeedback.class);
        Root<CVFeedback> root = query.from(CVFeedback.class);

        if (order) {
            query = query.select(root).orderBy(criteriaBuilder.asc(root.get(sortedField)));
        } else {
            query = query.select(root).orderBy(criteriaBuilder.desc(root.get(sortedField)));
        }

        TypedQuery<CVFeedback> typedQuery = getSession().createQuery(query);
        typedQuery.setFirstResult((pageNumber - 1) * itemsNumberInPage);
        typedQuery.setMaxResults(itemsNumberInPage);

        return typedQuery.getResultList();
    }

    @Override
    public List<CVFeedback> getFilteredEntitiesPage(String... params) {
        return null;
    }

    @Override
    public CVFeedback getEntityById(long id) {
        return getSession().get(CVFeedback.class, id);
    }
}