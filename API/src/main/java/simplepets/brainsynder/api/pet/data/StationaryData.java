package simplepets.brainsynder.api.pet.data;

import lib.brainsynder.item.ItemBuilder;
import org.bukkit.Material;
import simplepets.brainsynder.api.Namespace;
import simplepets.brainsynder.api.entity.IEntityPet;
import simplepets.brainsynder.api.entity.ambient.IEntityArmorStandPet;
import simplepets.brainsynder.api.entity.misc.IEntityControllerPet;
import simplepets.brainsynder.api.pet.PetData;

@Namespace(namespace = "stationary")
public class StationaryData extends PetData {
    public StationaryData() {
        addDefaultItem("true", new ItemBuilder(Material.SLIME_BALL)
                .withName("&#c8c8c8{name}: &atrue"));
        addDefaultItem("false", new ItemBuilder(Material.LEATHER_BOOTS)
                .withName("&#c8c8c8{name}: &cfalse"));
    }

    @Override
    public Object getDefaultValue() {
        return false;
    }

    @Override
    public void onLeftClick(IEntityPet entity) {
        entity.setStationary(!entity.isStationary());
    }

    @Override
    public Object value(IEntityPet entity) {
        return entity.isStationary();
    }

    @Override
    public boolean isModifiable(IEntityPet entity) {
        if (entity instanceof IEntityControllerPet controller) {
            controller.getVisibleEntity().setStationary(!controller.getVisibleEntity().isStationary());
            return false;
        }
        if (entity instanceof IEntityArmorStandPet) return false;
        return super.isModifiable(entity);
    }
}
