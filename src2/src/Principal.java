import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Principal {
    private static List<Producto> productos = new ArrayList<>();
    private static List<Usuario> usuarios = new ArrayList<>();
    private static List<Pedido> pedidos = new ArrayList<>();

    public static void main(String[] args) {

        productos.add(new Producto(1, "Laptop", "Laptop de alta gama", 1200.00, 10));
        productos.add(new Producto(2, "Mouse", "Mouse inalámbrico", 25.00, 50));
        usuarios.add(new Usuario("admin", "admin123", "Administrador"));
        usuarios.add(new Usuario("almacenero1", "almacenero123", "Almacenero"));
        usuarios.add(new Usuario("contador1", "contador123", "Contador"));

        Scanner scanner = new Scanner(System.in);

        while (true) {
            mostrarMenuPrincipal();
            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    iniciarSesion(scanner);
                    break;
                case 2:
                    System.out.println("Saliendo del sistema...");
                    return;
                default:
                    System.out.println("Opción inválida. Por favor, seleccione una opción válida.");
            }
        }
    }

    private static void mostrarMenuPrincipal() {
        System.out.println("\n--- Sistema de Gestión de Inventario ---");
        System.out.println("1. Iniciar sesión");
        System.out.println("2. Salir");
        System.out.print("Seleccione una opción: ");
    }

    private static void iniciarSesion(Scanner scanner) {
        System.out.print("Nombre de usuario: ");
        String nombreUsuario = scanner.nextLine();
        System.out.print("Contraseña: ");
        String contrasena = scanner.nextLine();


        for (Usuario usuario : usuarios) {
            if (usuario.getNombreUsuario().equals(nombreUsuario) && usuario.verificarContrasena(contrasena)) {
                System.out.println("¡Bienvenido, " + nombreUsuario + "!");
                mostrarMenuUsuario(scanner, usuario);
                return;
            }
        }

        System.out.println("Nombre de usuario o contraseña incorrectos.");
    }

    private static void mostrarMenuUsuario(Scanner scanner, Usuario usuario) {
        if (usuario.getRol().equals("Administrador")) {
            mostrarMenuAdministrador(scanner);
        } else if (usuario.getRol().equals("Almacenero")) {
            mostrarMenuAlmacenero(scanner);
        } else if (usuario.getRol().equals("Contador")) {
            mostrarMenuContador(scanner);
        }
    }

    private static void mostrarMenuAdministrador(Scanner scanner) {
        while (true) {
            System.out.println("\n--- Menú Administrador ---");
            System.out.println("1. Agregar producto");
            System.out.println("2. Modificar producto");
            System.out.println("3. Eliminar producto");
            System.out.println("4. Gestionar pedidos"); System.out.println("5. Generar informes");
            System.out.println("6. Administrar usuarios");
            System.out.println("7. Volver al menú principal");
            System.out.print("Seleccione una opción: ");

            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    agregarProducto(scanner);

                    break;
                case 2:
                    modificarProducto(scanner);
                    break;
                case 3:
                    eliminarProducto(scanner);
                    break;
                case 4:
                    gestionarPedidos(scanner);
                    break;
                case 5:
                    generarInformes(scanner);
                    break;
                case 6:
                    administrarUsuarios(scanner);
                    break;
                case 7:
                    return;
                default:
                    System.out.println("Opción inválida.");
            }
        }
    }

    private static void mostrarMenuAlmacenero(Scanner scanner) {
        while (true) {
            System.out.println("\n--- Menú Almacenero ---");
            System.out.println("1. Ver inventario de productos");
            System.out.println("2. Gestionar pedidos");
            System.out.println("3. Volver al menú principal");
            System.out.print("Seleccione una opción: ");

            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:

                    verInventarioDeProductos();
                    break;
                case 2:
                    gestionarPedidos(scanner);
                    break;
                case 3:
                    return;
                default:
                    System.out.println("Opción inválida.");
            }
        }
    }

    private static void mostrarMenuContador(Scanner scanner) {
        while (true) {
            System.out.println("\n--- Menú Contador ---");
            System.out.println("1. Ver inventario de productos");
            System.out.println("2. Generar informe de inventario");
            System.out.println("3. Volver al menú principal");
            System.out.print("Seleccione una opción: ");

            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:

                    verInventarioDeProductos();
                    break;
                case 2:
                    generarInformeInventario();
                    break;
                case 3:
                    return;
                default:
                    System.out.println("Opción inválida.");
            }
        }
    }

    private static void agregarProducto(Scanner scanner) {
        System.out.println("\n--- Agregar Producto ---");
        System.out.print("ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Descripción: ");
        String descripcion = scanner.nextLine();
        System.out.print("Precio: ");
        double precio = scanner.nextDouble();
        System.out.print("Cantidad en stock: ");
        int cantidadEnStock = scanner.nextInt();
        scanner.nextLine();

        Producto nuevoProducto = new Producto(id, nombre, descripcion, precio, cantidadEnStock);
        productos.add(nuevoProducto);

        System.out.println("Producto agregado correctamente.");
    }

    private static void modificarProducto(Scanner scanner) {
        System.out.println("\n--- Modificar Producto ---");
        System.out.print("Ingrese el ID del producto a modificar: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        for (Producto producto : productos) {
            if (producto.getID() == id) {
                System.out.print("Nuevo nombre: ");
                String nuevoNombre = scanner.nextLine();
                System.out.print("Nueva descripción: ");
                String nuevaDescripcion = scanner.nextLine();
                System.out.print("Nuevo precio: ");
                double nuevoPrecio = scanner.nextDouble();
                System.out.print("Nueva cantidad en stock: ");
                int nuevaCantidadEnStock = scanner.nextInt();
                scanner.nextLine();

                producto.setNombre(nuevoNombre);
                producto.setDescripcion(nuevaDescripcion);
                producto.setPrecio(nuevoPrecio);
                producto.setCantidadEnStock(nuevaCantidadEnStock);

                System.out.println("Producto modificado correctamente.");
                return;
            }
        }

        System.out.println("Producto no encontrado.");
    }

    private static void eliminarProducto(Scanner scanner) {
        System.out.println("\n--- Eliminar Producto ---");
        System.out.print("Ingrese el ID del producto a eliminar: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        for (Producto producto : productos) {
            if (producto.getID() == id) {
                productos.remove(producto);
                System.out.println("Producto eliminado correctamente.");
                return;
            }
        }

        System.out.println("Producto no encontrado.");

    }

    private static void verUsuarios() {
        System.out.println("\n--- Usuarios ---");
        if (usuarios.isEmpty()) {
            System.out.println("No hay usuarios registrados.");
            return;
        }

        for (Usuario usuario : usuarios) {
            System.out.println("Nombre de usuario: " + usuario.getNombreUsuario());
            System.out.println("Rol: " + usuario.getRol());
            System.out.println("----------------------");

        }
    }

    private static void verInventarioDeProductos() {
        System.out.println("\n--- Inventario de Productos ---");
        if (productos.isEmpty()) {
            System.out.println("No hay productos registrados.");
            return;
        }

        Informe.generarInformeInventario(productos);
    }


    private static void gestionarPedidos(Scanner scanner) {
        while (true) {
            System.out.println("\n--- Gestionar Pedidos ---");
            System.out.println("1. Crear pedido");
            System.out.println("2. Ver pedidos");
            System.out.println("3. Cambiar estado de pedido");
            System.out.println("4. Volver al menú anterior");
            System.out.print("Seleccione una opción: ");

            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    crearPedido(scanner);

                    break;
                case 2:
                    verPedidos();
                    break;
                case 3:
                    cambiarEstadoPedido(scanner);
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Opción inválida.");
            }
        }
    }

    private static void generarInformes(Scanner scanner) {
        while (true) {
            System.out.println("\n--- Generar Informes ---");
            System.out.println("1. Generar informe de pedidos");
            System.out.println("2. Generar informe de inventario");
            System.out.println("3. Volver al menú anterior");
            System.out.print("Seleccione una opción: ");

            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:

                    generarInformePedidos();
                    break;
                case 2:
                    generarInformeInventario();
                    break;
                case 3:
                    return;
                default:
                    System.out.println("Opción inválida.");
            }
        }
    }

    private static void administrarUsuarios(Scanner scanner) {
        while (true) {
            System.out.println("\n--- Administrar Usuarios ---");
            System.out.println("1. Agregar usuario");
            System.out.println("2. Modificar usuario");
            System.out.println("3. Eliminar usuario");
            System.out.println("4. Ver usuarios");
            System.out.println("5. Volver al menú anterior");
            System.out.print("Seleccione una opción: ");

            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    agregarUsuario(scanner);

                    break;
                case 2:
                    modificarUsuario(scanner);
                    break;
                case 3:
                    eliminarUsuario(scanner);
                    break;
                case 4:
                    verUsuarios();
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Opción inválida.");
            }
        }
    }

    private static void crearPedido(Scanner scanner) {
        System.out.println("\n--- Crear Pedido ---");
        System.out.print("ID de Pedido: ");
        int idPedido = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Fecha y hora (formato: yyyy-MM-dd HH:mm:ss): ");
        String fechaHora = scanner.nextLine();

        Pedido nuevoPedido = new Pedido(idPedido, fechaHora);

        while (true) {
            System.out.print("Ingrese el ID del producto a agregar al pedido (o 0 para finalizar): ");
            int idProducto = scanner.nextInt();
            scanner.nextLine();

            if (idProducto == 0) {
                break;
            }

            for (Producto producto : productos) {
                if (producto.getID() == idProducto) {
                    System.out.print("Cantidad: ");
                    int cantidad = scanner.nextInt();
                    scanner.nextLine();

                    if (producto.getCantidadEnStock() >= cantidad) {

                        producto.actualizarCantidadEnStock(-cantidad);

                        Producto productoPedido = new Producto(producto.getID(), producto.getNombre(), producto.getDescripcion(), producto.getPrecio(), cantidad);
                        nuevoPedido.agregarProducto(productoPedido);

                        System.out.println("Producto agregado al pedido.");
                    } else {
                        System.out.println("No hay suficiente stock de este producto.");
                    }
                    break;
                }
            }
        }

        pedidos.add(nuevoPedido);
        System.out.println("Pedido creado correctamente.");
    }

    private static void verPedidos() {
        System.out.println("\n--- Pedidos ---");
        if (pedidos.isEmpty()) {
            System.out.println("No hay pedidos registrados.");
            return;
        }
        Informe.generarInformePedidos(pedidos);
    }

    private static void cambiarEstadoPedido(Scanner scanner) {
        System.out.println("\n--- Cambiar Estado de Pedido ---");
        System.out.print("Ingrese el ID del pedido: ");
        int idPedido = scanner.nextInt();
        scanner.nextLine();

        for (Pedido pedido : pedidos) {
            if (pedido.getIDPedido() == idPedido) {
                System.out.println("Estado actual: " + pedido.getEstadoPedido());
                System.out.print("Nuevo estado (pendiente, enviado, entregado): ");
                String nuevoEstado = scanner.nextLine();
                pedido.cambiarEstadoPedido(nuevoEstado);
                System.out.println("Estado del pedido actualizado correctamente.");
                return;
            }
        }

        System.out.println("Pedido no encontrado.");
    }

    private static void generarInformePedidos() {
        System.out.println("\n--- Informe de Pedidos ---");
        if (pedidos.isEmpty()) {
            System.out.println("No hay pedidos registrados.");
            return;
        }
        Informe.generarInformePedidos(pedidos);
    }

    private static void generarInformeInventario() {
        System.out.println("\n--- Informe de Inventario ---");
        if (productos.isEmpty()) {
            System.out.println("No hay productos registrados.");
            return;
        }
        Informe.generarInformeInventario(productos);
    }

    private static void agregarUsuario(Scanner scanner) {
        System.out.println("\n--- Agregar Usuario ---");
        System.out.print("Nombre de usuario: ");
        String nombreUsuario = scanner.nextLine();
        System.out.print("Contraseña: ");
        String contrasena = scanner.nextLine();
        System.out.print("Rol (Administrador, Almacenero, Contador): ");
        String rol = scanner.nextLine();

        Usuario nuevoUsuario = new Usuario(nombreUsuario, contrasena, rol);
        usuarios.add(nuevoUsuario);

        System.out.println("Usuario agregado correctamente.");
    }

    private static void modificarUsuario(Scanner scanner) {
        System.out.println("\n--- Modificar Usuario ---");
        System.out.print("Ingrese el nombre de usuario a modificar: ");
        String nombreUsuario = scanner.nextLine();

        for (Usuario usuario : usuarios) {
            if (usuario.getNombreUsuario().equals(nombreUsuario)) {
                System.out.print("Nueva contraseña: ");
                String nuevaContrasena = scanner.nextLine();
                System.out.print("Nuevo rol (Administrador, Almacenero, Contador): ");
                String nuevoRol = scanner.nextLine();

                usuario.setContrasena(nuevaContrasena);
                usuario.setRol(nuevoRol);

                System.out.println("Usuario modificado correctamente.");
                return;
            }
        }

        System.out.println("Usuario no encontrado.");
    }

    private static void eliminarUsuario(Scanner scanner) {
        System.out.println("\n--- Eliminar Usuario ---");
        System.out.print("Ingrese el nombre de usuario a eliminar: ");
        String nombreUsuario = scanner.nextLine();

        for (Usuario usuario : usuarios) {
            if (usuario.getNombreUsuario().equals(nombreUsuario)) {
                usuarios.remove(usuario);
                System.out.println("Usuario eliminado correctamente.");
                return;
            }
        }

        System.out.println("Usuario no encontrado.");
    }
}