package at.fh.seriesX.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import at.fh.seriesX.model.SeasonModel;

@Repository
@Transactional
public interface SeasonRepository extends JpaRepository<SeasonModel,Integer> {

	
}
