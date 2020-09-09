package kobo6.intro.service;

import kobo6.intro.model.KnowledgeEntity;
import kobo6.intro.model.KnowledgeEntity_;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import java.sql.Timestamp;

@Stateless
public class KnowledgeService extends AbstractService<KnowledgeEntity>{
    @PersistenceContext(name="Knowledge-persistence-unit")
    private EntityManager entityManager;

    public KnowledgeService(){
        super(KnowledgeEntity.class);
    }

    public EntityManager getEntityManager(){
        return entityManager;
    }

    public KnowledgeEntity findById(Long id){
        CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<KnowledgeEntity> cq = cb.createQuery(KnowledgeEntity.class);
        Root<KnowledgeEntity> model = cq.from(KnowledgeEntity.class);
        cq.where(cb.equal(model.get(KnowledgeEntity_.id), id));
        return getEntityManager().createQuery(cq).getSingleResult();
    }

    @TransactionAttribute(value = TransactionAttributeType.REQUIRED)
    public void addKnowledge(KnowledgeEntity knowledge) {
        knowledge.setCreateAt(new Timestamp(System.currentTimeMillis()));
        knowledge.setUpdateAt(new Timestamp(System.currentTimeMillis()));
        create(knowledge);
    }

    @TransactionAttribute(value = TransactionAttributeType.REQUIRED)
    public void editKnowledge(KnowledgeEntity knowledge) {
        knowledge.setUpdateAt(new Timestamp(System.currentTimeMillis()));
        edit(knowledge);
    }
}
