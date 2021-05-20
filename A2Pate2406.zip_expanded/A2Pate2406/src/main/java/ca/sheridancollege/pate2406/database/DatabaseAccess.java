package ca.sheridancollege.pate2406.database;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import ca.sheridancollege.pate2406.beans.Restaurant;

@Repository
public class DatabaseAccess {

	@Autowired
	NamedParameterJdbcTemplate template;
	
	public void insertReview(Restaurant res) {
		String query = "INSERT INTO review(restaurantName, review, reviewDate, reviewTime) VALUES (:n, :r, :d, :t)";
		MapSqlParameterSource namedParameters = 
				new MapSqlParameterSource();
		namedParameters.addValue("n", res.getRestaurantName());
		namedParameters.addValue("r", res.getReview());
		namedParameters.addValue("d", res.getDate());
		namedParameters.addValue("t", res.getTime());
		
		template.update(query, namedParameters);
	}
	
	public ArrayList<Restaurant> getAllReviews(){
		
		String query = "SELECT id,restaurantName, review, reviewDate, reviewTime FROM review";
		ArrayList<Restaurant> list = new ArrayList<>();
		List<Map<String, Object>> rows = template.queryForList(query, new HashMap<String,Object>());
		//System.out.println(rows);
		
		for (Map<String, Object> row : rows) {
			Date date = (Date)row.get("reviewDate");
			Time time = (Time)row.get("reviewTime");
			list.add(new Restaurant((Long) row.get("id"),
					(String) row.get("restaurantName"),
					((String) row.get("review")),
					date.toLocalDate(),time.toLocalTime()));
		}
		
		return list;
	}
}
