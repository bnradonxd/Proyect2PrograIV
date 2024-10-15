import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static List<Producto> productos = new ArrayList<>();
    private static List<Usuario>
    usuarios = new ArrayList<>();
    private static List<Venta> ventas = new ArrayList<>();

    public static void main(String[] args) {
        productos.add(new Producto(1, "Laptop", "Laptop de alta gama", 1200, 10));
        productos.add(new Producto(2, "Mouse", "Mouse inalámbrico", 20, 50));
        usuarios.add(new Usuario("admin", "admin", "Administrador"));
        usuarios.add(new Usuario("vendedor1", "1234", "Vendedor"));
        usuarios.add(new Usuario("gerente1", "4321", "Gerente"));
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
        System.out.println("\n--- Menú Principal ---");
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
        switch (usuario.getRol()) {
            case "Administrador":
                mostrarMenuAdministrador(scanner);
                break;
            case "Vendedor":
                mostrarMenuVendedor(scanner);
                break;
            case "Gerente":
                mostrarMenuGerente(scanner);
                break;
            default:
                System.out.println("Rol de usuario no reconocido.");
        }
    }

    private static void mostrarMenuAdministrador(Scanner scanner) {
        while (true) {
            System.out.println("\n--- Menú Administrador ---");
            System.out.println("1. Agregar producto");
            System.out.println("2. Modificar producto");
            System.out.println("3. Eliminar producto");
            System.out.println("4. Generar informe de ventas");
            System.out.println("5. Generar informe de inventario");
            System.out.println("6. Administrar usuarios");
            System.out.println("7. Cerrar sesión");
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
                    Informe.generarInformeVentas(ventas);
                    break;
                case 5:
                    Informe.generarInformeInventario(productos);
                    break;
                case 6:
                    administrarUsuarios(scanner);
                    break;
                case 7:
                    System.out.println("Cerrando sesión...");
                    return;
                default:
                    System.out.println("Opción inválida. Por favor, seleccione una opción válida.");
            }
        }
    }

    private static void mostrarMenuVendedor(Scanner scanner) {
        while (true) {
            System.out.println("\n--- Menú Vendedor ---");
            System.out.println("1. Ver inventario de productos");
            System.out.println("2. Realizar venta");
            System.out.println("3. Cerrar sesión");
            System.out.print("Seleccione una opción: ");

            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:

                    Informe.generarInformeInventario(productos);
                    break;
                case 2:
                    realizarVenta(scanner);
                    break;
                case 3:
                    System.out.println("Cerrando sesión...");
                    return;
                default:
                    System.out.println("Opción inválida. Por favor, seleccione una opción válida.");
            }
        }
    }

    private static void realizarVenta(Scanner scanner) {
        System.out.println("\n--- Realizar Venta ---");
        Venta nuevaVenta = new Venta(ventas.size() + 1);

        while (true) {
            System.out.print("Ingrese el ID del producto a vender (0 para finalizar): ");
            int IDProducto = scanner.nextInt();
            scanner.nextLine();

            if (IDProducto == 0) {
                break;
            }

            System.out.print("Ingrese la cantidad: ");
            int cantidad = scanner.nextInt();
            scanner.nextLine();

            for (Producto producto : productos) {
                if (producto.getID() == IDProducto) {
                    if (producto.getCantidadEnStock() >= cantidad) {
                        nuevaVenta.agregarProducto(producto, cantidad);
                        System.out.println("Producto agregado a la venta.");
                    } else {
                        System.out.println("No hay suficiente stock de este producto.");
                    }
                    break;
                }
            }
        }

        ventas.add(nuevaVenta);
        System.out.println("Venta realizada con éxito. Total: " + nuevaVenta.getTotalVenta());
    }

    private static void mostrarMenuGerente(Scanner scanner) {
        while (true) {
            System.out.println("\n--- Menú Gerente ---");
            System.out.println("1. Ver inventario de productos");
            System.out.println("2. Generar informe de ventas");
            System.out.println("3. Cerrar sesión");
            System.out.print("Seleccione una opción: ");

            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:

                    Informe.generarInformeInventario(productos);
                    break;
                case 2:
                    Informe.generarInformeVentas(ventas);
                    break;
                case 3:
                    System.out.println("Cerrando sesión...");
                    return;
                default:
                    System.out.println("Opción inválida. Por favor, seleccione una opción válida.");
            }
        }
    }

    private static void agregarProducto(Scanner scanner) {
        System.out.print("ID del producto: ");
        int ID = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Nombre del producto: ");
        String nombre = scanner.nextLine();
        System.out.print("Descripción del producto: ");
        String descripcion = scanner.nextLine();
        System.out.print("Precio del producto: ");
        double precio = scanner.nextDouble();
        System.out.print("Cantidad en stock: ");
        int cantidadEnStock = scanner.nextInt();

        productos.add(new Producto(ID, nombre, descripcion, precio, cantidadEnStock));
        System.out.println("Producto agregado correctamente.");
    }

    private static void modificarProducto(Scanner scanner) {
        System.out.print("ID del producto a modificar: ");
        int ID = scanner.nextInt();
        scanner.nextLine();

        for (Producto producto : productos) {
            if (producto.getID() == ID) {
                System.out.print("Nuevo nombre del producto: ");
                String nombre = scanner.nextLine();
                System.out.print("Nueva descripción del producto: ");
                String descripcion = scanner.nextLine();
                System.out.print("Nuevo precio del producto: ");
                double precio = scanner.nextDouble();
                System.out.print("Nueva cantidad en stock: ");
                int cantidadEnStock = scanner.nextInt();

                producto.setNombre(nombre);
                producto.setDescripcion(descripcion);
                producto.setPrecio(precio);
                producto.setCantidadEnStock(cantidadEnStock);
                System.out.println("Producto modificado correctamente.");
                return;
            }
        }

        System.out.println("Producto no encontrado.");
    }

    private static void eliminarProducto(Scanner scanner) {
        System.out.print("ID del producto a eliminar: ");
        int ID = scanner.nextInt();
        scanner.nextLine();

        for (Producto producto : productos) {
            if (producto.getID() == ID) {
                productos.remove(producto);
                System.out.println("Producto eliminado correctamente.");
                return;
            }
        }

        System.out.println("Producto no encontrado.");
    }
    private static void administrarUsuarios(Scanner scanner) {
        while (true) {
            System.out.println("\n--- Administrar Usuarios ---");
            System.out.println("1. Agregar usuario");
            System.out.println("2. Modificar usuario");
            System.out.println("3. Eliminar usuario");
            System.out.println("4. Volver al menú anterior");
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
                    return;
                default:
                    System.out.println("Opción inválida. Por favor, seleccione una opción válida.");
            }
        }
    }

    private static void agregarUsuario(Scanner scanner) {
        System.out.print("Nombre de usuario: ");
        String nombreUsuario = scanner.nextLine();
        System.out.print("Contraseña: ");
        String contrasena = scanner.nextLine();
        System.out.print("Rol(Administrador, Vendedor, Gerente): ");
        String rol = scanner.nextLine();

        usuarios.add(new Usuario(nombreUsuario, contrasena, rol));
        System.out.println("Usuario agregado correctamente.");
    }

    private static void modificarUsuario(Scanner scanner) {
        System.out.print("Nombre de usuario a modificar: ");
        String nombreUsuario = scanner.nextLine();

        for (Usuario usuario : usuarios) {
            if (usuario.getNombreUsuario().equals(nombreUsuario)) {
                System.out.print("Nueva contraseña: ");
                String contrasena = scanner.nextLine();
                System.out.print("Nuevo rol (Administrador, Vendedor, Gerente): ");
                String rol = scanner.nextLine();

                usuario.setContrasena(contrasena);
                usuario.setRol(rol);
                System.out.println("Usuario modificado correctamente.");
                return;
            }
        }

        System.out.println("Usuario no encontrado.");
    }

    private static void eliminarUsuario(Scanner scanner) {
        System.out.print("Nombre de usuario a eliminar: ");
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
