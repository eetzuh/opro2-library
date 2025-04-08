package repository;

import java.util.HashSet;
import java.util.List;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import model.Librarian;
import model.Member;

@Dependent
public class LibrarianRepository {
	@Inject
	private EntityManager em;
	
	@Transactional
	public Librarian createLibrarian(Librarian l) {
		return em.merge(l);
	}
	
	@Transactional
	public List<Librarian> getAllLibrarians(){
		List<Librarian> librarians  = em.createNamedQuery(Librarian.GET_ALL_LIBRARIANS, Librarian.class)
				.getResultList();
		for (Librarian librarian : librarians) {
			List<Member> members = em.createNamedQuery(Member.GET_MEMBERS_FOR_LIBRARIAN, Member.class)
					.setParameter("id", librarian.getId()).getResultList();
			librarian.setMembers(new HashSet<>(members));
		}
		return librarians;
		
	}
	
}
