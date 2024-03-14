package onlineretailer;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

public interface ProductSuggestionRepository extends CrudRepository<ProductSuggestion, Long> {

    @Query("update ProductSuggestion p set p.recommendedPrice=?1 where p.id = ?2")
    @Modifying(flushAutomatically=true, clearAutomatically=true)
    @Transactional
    int modifyPrice(double newPrice, Long id);

    @Query("update ProductSuggestion p set p.estimatedAnnualSales=?1 where p.id = ?2")
    @Modifying(flushAutomatically=true, clearAutomatically=true)
    @Transactional
    int modifySales(long newSales, Long id);
}
