import servicios.*;
import modelo.*;
import java.util.Scanner;
import java.util.InputMismatchException;
import java.time.LocalDate;

public class Main {
    private static ServicioCliente servicioCliente = new ServicioCliente();
    private static ServicioVenta servicioVenta = new ServicioVenta();
    private static ServicioProveedor servicioProveedor = new ServicioProveedor();
    private static ServicioPromocion servicioPromocion = new ServicioPromocion();
    private static ServicioPuntosFidelidad servicioPuntosFidelidad = new ServicioPuntosFidelidad();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion = -1;

        do {
            System.out.println("=== SISTEMA DE GESTIÓN DE INVENTARIO ===");
            System.out.println("1. Gestionar Clientes");
            System.out.println("2. Gestionar Ventas");
            System.out.println("3. Gestionar Proveedores");
            System.out.println("4. Gestionar Promociones");
            System.out.println("5. Gestionar Puntos de Fidelidad");
            System.out.println("0. Salir");
            System.out.print("Selecciona una opción: ");
            try {
                opcion = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Por favor, ingrese un número válido.");
                scanner.next();
                continue;
            }

            switch (opcion) {
                case 1:
                    menuClientes(scanner);
                    break;
                case 2:
                    menuVentas(scanner);
                    break;
                case 3:
                    menuProveedores(scanner);
                    break;
                case 4:
                    menuPromociones(scanner);
                    break;
                case 5:
                    menuPuntosFidelidad(scanner);
                    break;
                case 0:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Esa opción no es válida.");
            }
        } while (opcion != 0);
    }

    public static void menuClientes(Scanner scanner) {
        System.out.println("--- Gestión de Clientes ---");
        System.out.println("1. Agregar Cliente");
        System.out.println("2. Eliminar Cliente");
        System.out.println("3. Buscar Cliente");
        System.out.println("4. Generar informe de Clientes");
        System.out.print("Selecciona una opción: ");
        int opcion = scanner.nextInt();

        switch (opcion) {
            case 1:
                agregarCliente(scanner);
                break;
            case 2:
                eliminarCliente(scanner);
                break;
            case 3:
                buscarCliente(scanner);
                break;
            default:
                System.out.println("Esa opción no es válida.");
        }
    }

    public static void menuVentas(Scanner scanner) {
        System.out.println("--- Gestión de Ventas ---");
        System.out.println("1. Agregar Venta");
        System.out.println("2. Eliminar Venta");
        System.out.println("3. Buscar Venta");
        System.out.print("Selecciona una opción: ");
        int opcion = scanner.nextInt();

        switch (opcion) {
            case 1:
                agregarVenta(scanner);
                break;
            case 2:
                eliminarVenta(scanner);
                break;
            case 3:
                buscarVenta(scanner);
                break;
            default:
                System.out.println("Esa opción no es válida.");
        }
    }

    public static void menuProveedores(Scanner scanner) {
        System.out.println("--- Gestión de Proveedores ---");
        System.out.println("1. Agregar Proveedor");
        System.out.println("2. Eliminar Proveedor");
        System.out.println("3. Buscar Proveedor");
        System.out.println("4. Modificar Proveedor");
        System.out.println("5. Asociar producto a Proveedor");
        System.out.println("6. Generar informe de Proveedores");
        System.out.print("Selecciona una opción: ");
        int opcion = scanner.nextInt();

        switch (opcion) {
            case 1:
                agregarProveedor(scanner);
                break;
            case 2:
                eliminarProveedor(scanner);
                break;
            case 3:
                buscarProveedor(scanner);
                break;
            case 4:
                modificarProveedor(scanner);
                break;
            case 5:
                asociarProductoAProveedor(scanner);
                break;
            case 6:
                System.out.println(servicioProveedor.generarInformeProveedores());

                break;
            default:
                System.out.println("Esa opción no es válida.");
        }
    }

    public static void menuPromociones(Scanner scanner) {
        System.out.println("--- Gestión de Promociones ---");
        System.out.println("1. Agregar Promoción");
        System.out.println("2. Eliminar Promoción");
        System.out.println("3. Buscar Promoción");
        System.out.println("4. Modificar Promoción");
        System.out.print("Selecciona una opción: ");
        int opcion = scanner.nextInt();

        switch (opcion) {
            case 1:
                agregarPromocion(scanner);
                break;
            case 2:
                eliminarPromocion(scanner);
                break;
            case 3:
                buscarPromocion(scanner);
                break;
            default:
                System.out.println("Esa opción no es válida.");
        }
    }

    public static void menuPuntosFidelidad(Scanner scanner) {
        System.out.println("--- Gestión de Puntos de Fidelidad ---");
        System.out.println("1. Agregar Puntos");
        System.out.println("2. Redimir Puntos");
        System.out.println("3. Consultar Puntos");
        System.out.print("Selecciona una opción: ");
        int opcion = scanner.nextInt();

        switch (opcion) {
            case 1:
                agregarPuntos(scanner);
                break;
            case 2:
                redimirPuntos(scanner);
                break;
            case 3:
                consultarPuntos(scanner);
                break;
            default:
                System.out.println("Esa opción no es válida.");
        }
    }

    public static void agregarCliente(Scanner scanner) {
        System.out.println("Ingrese ID del cliente: ");
        int id = scanner.nextInt();
        System.out.println("Ingrese nombre del cliente: ");
        String nombre = scanner.next();
        System.out.println("Ingrese email del cliente: ");
        String email = scanner.next();

        Cliente nuevoCliente = new Cliente(id, nombre, email);
        servicioCliente.agregarCliente(nuevoCliente);
        System.out.println("Cliente agregado exitosamente. :)");
    }

    public static void eliminarCliente(Scanner scanner) {
        System.out.println("Ingrese ID del cliente a eliminar: ");
        int id = scanner.nextInt();
        servicioCliente.eliminarCliente(id);
        System.out.println("Cliente eliminado. :(");
    }

    public static void buscarCliente(Scanner scanner) {
        System.out.println("Ingrese ID del cliente a buscar: ");
        int id = scanner.nextInt();
        Cliente cliente = servicioCliente.buscarCliente(id);

        if (cliente != null) {
            System.out.println("Datos del cliente: " + cliente.getNombre() + ", Email: " + cliente.getEmail());
        } else {
            System.out.println("El cliente no existe.");
        }
    }

    public static void generarInformeClientes() {
        String informe = servicioCliente.generarInformeClientes();
        System.out.println(informe);
    }


    public static void agregarVenta(Scanner scanner) {
        System.out.print("Ingrese ID de la venta: ");
        int id = scanner.nextInt();
        System.out.print("Ingrese ID del cliente: ");
        int idCliente = scanner.nextInt();
        System.out.print("Ingrese ID del producto: ");
        int idProducto = scanner.nextInt();
        System.out.print("Ingrese monto: ");
        double monto = scanner.nextDouble();

        Venta nuevaVenta = new Venta(id, idCliente, idProducto, monto);

        System.out.println("Venta agregada: " + nuevaVenta);
    }

    public static void eliminarVenta(Scanner scanner) {
        System.out.print("Ingrese ID de la venta a eliminar: ");
        int id = scanner.nextInt();

        System.out.println("Venta eliminada con ID: " + id);
    }

    public static void buscarVenta(Scanner scanner) {
        System.out.print("Ingrese ID de la venta a buscar: ");
        int id = scanner.nextInt();
        System.out.println("Detalles de la venta con ID: " + id);
    }

    public static void agregarProveedor(Scanner scanner) {
        System.out.print("Ingrese ID del proveedor: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Ingrese nombre del proveedor: ");
        String nombre = scanner.nextLine();

        Proveedor nuevoProveedor = new Proveedor(id, nombre);
        servicioProveedor.agregarProveedor(nuevoProveedor);
        System.out.println("Proveedor agregado: " + nuevoProveedor.getNombre());

    }

    public static void eliminarProveedor(Scanner scanner) {
        System.out.print("Ingrese ID del proveedor a eliminar: ");
        int id = scanner.nextInt();
        System.out.println("Proveedor eliminado con ID: " + id);
    }

    public static void buscarProveedor(Scanner scanner) {
        System.out.print("Ingrese ID del proveedor a buscar: ");
        int id = scanner.nextInt();
        System.out.println("Detalles del proveedor con ID: " + id);
    }

    public static void modificarProveedor(Scanner scanner) {
        System.out.print("Ingrese ID del proveedor a modificar: ");
        int id = scanner.nextInt();

        Proveedor proveedorExistente = servicioProveedor.buscarProveedor(id);
        if (proveedorExistente != null) {
            System.out.print("Ingrese nuevo nombre del proveedor: ");
            String nuevoNombre = scanner.next();
            Proveedor proveedorModificado = new Proveedor(id, nuevoNombre);
            servicioProveedor.modificarProveedor(proveedorModificado);
            System.out.println("Proveedor modificado exitosamente.");
        } else {
            System.out.println("Proveedor no encontrado.");
        }
    }
    public static void asociarProductoAProveedor(Scanner scanner) {
        System.out.print("Ingrese ID del proveedor: ");
        int idProveedor = scanner.nextInt();
        System.out.print("Ingrese ID del producto: ");
        int idProducto = scanner.nextInt();


        Proveedor proveedor = servicioProveedor.buscarProveedor(idProveedor);
        Producto producto = servicioProducto.buscarProducto(idProducto);

        if (proveedor != null && producto != null) {
            proveedor.agregarProducto(producto);
            System.out.println("Producto asociado exitosamente.");
        } else {
            System.out.println("Proveedor o producto no encontrado.");
        }
    }

    public static void generarInformeProveedores() {
        String informe = servicioProveedor.generarInformeProveedores();
        System.out.println(informe);
    }

    public static void agregarPromocion(Scanner scanner) {
        System.out.print("Ingrese ID de la promoción: ");
        int id = scanner.nextInt();
        System.out.print("Ingrese descripción de la promoción: ");
        String descripcion = scanner.next();
        System.out.print("Ingrese porcentaje de descuento: ");
        double porcentajeDescuento = scanner.nextDouble();
        System.out.print("Ingrese fecha de inicio (YYYY-MM-DD): ");
        LocalDate fechaInicio = LocalDate.parse(scanner.next());
        System.out.print("Ingrese fecha de fin (YYYY-MM-DD): ");
        LocalDate fechaFin = LocalDate.parse(scanner.next());
        System.out.print("¿Está activa? (true/false): ");
        boolean activo = scanner.nextBoolean();

        Promocion nuevaPromocion = new Promocion(id, descripcion, porcentajeDescuento, fechaInicio, fechaFin, activo);
        System.out.println("Promoción agregada: " + nuevaPromocion.getDescripcion());
    }

    public static void eliminarPromocion(Scanner scanner) {
        System.out.print("Ingrese ID de la promoción a eliminar: ");
        int id = scanner.nextInt();
        System.out.println("Promoción eliminada con ID: " + id);
    }

    public static void buscarPromocion(Scanner scanner) {
        System.out.print("Ingrese ID de la promoción a buscar: ");
        int id = scanner.nextInt();
        System.out.println("Detalles de la promoción con ID: " + id);
    }

    public static void modificarPromocion(Scanner scanner) {
        System.out.print("Ingrese ID de la promoción a modificar: ");
        int id = scanner.nextInt();
        Promocion promocionExistente = servicioPromocion.buscarPromocion(id);
        if (promocionExistente != null) {
            System.out.print("Ingrese nueva descripción de la promoción: ");
            String nuevaDescripcion = scanner.next();
            System.out.print("Ingrese nuevo porcentaje de descuento: ");
            double nuevoDescuento = scanner.nextDouble();

            Promocion promocionModificada = new Promocion(id, nuevaDescripcion, nuevoDescuento, promocionExistente.getFechaInicio(), promocionExistente.getFechaFin(), promocionExistente.isActiva());
            servicioPromocion.modificarPromocion(promocionModificada);
            System.out.println("Promoción modificada exitosamente.");
        } else {
            System.out.println("Promoción no encontrada.");
        }
    }

    public static void agregarPuntos(Scanner scanner) {
        System.out.print("Ingrese ID del cliente: ");
        int idCliente = scanner.nextInt();
        System.out.print("Ingrese cantidad de puntos a agregar: ");
        int puntos = scanner.nextInt();

        servicioPuntosFidelidad.agregarPuntos(idCliente, puntos);
        System.out.println("Puntos agregados al cliente con ID: " + idCliente);
    }

    public static void redimirPuntos(Scanner scanner) {
        System.out.print("Ingrese ID del cliente: ");
        int idCliente = scanner.nextInt();
        System.out.print("Ingrese cantidad de puntos a redimir: ");
        int puntos = scanner.nextInt();

        ServicioPuntosFidelidad servicio = new ServicioPuntosFidelidad();
        if (servicio.redimirPuntos(idCliente, puntos)) {
            System.out.println("Puntos redimidos del cliente con ID: " + idCliente);
        } else {
            System.out.println("No se pudo redimir puntos. Puntos insuficientes.");
        }
    }

    public static void consultarPuntos(Scanner scanner) {
        System.out.print("Ingrese ID del cliente: ");
        int idCliente = scanner.nextInt();

        ServicioPuntosFidelidad servicio = new ServicioPuntosFidelidad();
        int puntos = servicio.consultarPuntos(idCliente);
        System.out.println("Puntos del cliente con ID " + idCliente + ": " + puntos);
    }
}
