package servicios;

import modelo.Promocion;
import java.util.ArrayList;
import java.util.List;

public class ServicioPromocion {
    private List<Promocion> promociones = new ArrayList<>();

    public void agregarPromocion(Promocion promocion) {
        promociones.add(promocion);
    }

    public void eliminarPromocion(int idPromocion) {
        promociones.removeIf(promocion -> promocion.getId() == idPromocion);
    }

    public Promocion buscarPromocion(int idPromocion) {
        return promociones.stream().filter(promocion -> promocion.getId() == idPromocion).findFirst().orElse(null);
    }

    public void modificarPromocion(Promocion promocionModificada) {
        for (int i = 0; i < promociones.size(); i++) {
            Promocion promocion = promociones.get(i);
            if (promocion.getId() == promocionModificada.getId()) {
                promociones.set(i, promocionModificada);
                break;
            }
        }
    }

    public String generarInformePromociones() {
        StringBuilder informe = new StringBuilder("Informe de Promociones:\n");
        for (Promocion promocion : promociones) {
            informe.append("ID: ").append(promocion.getId())
                    .append(", Descripción: ").append(promocion.getDescripcion())
                    .append(", Descuento: ").append(promocion.getDescuento())
                    .append("%, Activa: ").append(promocion.isActiva()).append("\n");
        }
        return informe.toString();
    }
}
