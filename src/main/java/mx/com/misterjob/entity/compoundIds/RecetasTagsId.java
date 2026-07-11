package mx.com.misterjob.entity.compoundIds;

import java.io.Serializable;
import java.util.Objects;

public class RecetasTagsId implements Serializable {
	private Integer idRecipe;
	private Integer idTag;
	
	public RecetasTagsId() {}

    public RecetasTagsId(Integer idRecipe, Integer idTag) {
        this.idRecipe = idRecipe;
        this.idTag = idTag;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RecetasTagsId that = (RecetasTagsId) o;
        return Objects.equals(idRecipe, that.idRecipe) && Objects.equals(idTag, that.idTag);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idRecipe, idTag);
    }
}
