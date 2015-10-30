package springdata;

import com.google.common.collect.ImmutableSet;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:/spring/*-context.xml"})
@TestExecutionListeners(listeners = {
        DependencyInjectionTestExecutionListener.class,
        DirtiesContextTestExecutionListener.class,
        TransactionalTestExecutionListener.class
})
@Transactional
public class LevelTableIT {

    @PersistenceContext
    private EntityManager em;

    @Test
    public void test() {
        Level3 l3 = new Level3();

        Level2 l2 = new Level2();
        l2.setKey("L2-0");
        l2.setLevel3s(ImmutableSet.of(l3));

        Level1 l1 = new Level1();
        l1.setKey("L1-0");
        l1.setLevel2s(ImmutableSet.of(l2));

        em.persist(l1);
        em.flush();
        em.clear();

        final Level1 level1 = em.find(Level1.class, "L1-0");
        System.out.println(level1);
    }
}
