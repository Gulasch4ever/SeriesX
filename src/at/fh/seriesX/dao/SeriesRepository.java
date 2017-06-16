package at.fh.seriesX.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import at.fh.seriesX.model.SeriesModel;
import org.springframework.data.repository.query.Param;


@Repository
@Transactional
public interface SeriesRepository extends JpaRepository<SeriesModel,Integer> {

	public List<SeriesModel> findByTitle(String title);
	
	public List<SeriesModel> findByGenre(String title);
	
	//NamedQueries
	public List<SeriesModel> doANameSearchWithLike(@Param("search")String title);
	
	public List<SeriesModel> deleteByGenre(String title);
	
	public List<SeriesModel> findByTitleContainingAllIgnoreCase(String title);
	
	public List<SeriesModel> findAllOrderByTitle(String title);
	
	public List<SeriesModel> findTop10ByOrderByGenreAsc(String title);
}
