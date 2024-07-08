-- Eliminar todos los datos existentes en la tabla topicos
DELETE FROM topicos;

-- Insertar 10 datos de prueba en la tabla topicos
INSERT INTO topicos (titulo, mensaje, fecha, estatus, autor, curso) VALUES
('Introducción a Java', 'Mensaje sobre Java', '2023-01-01', true, 1, 101),
('Bases de Datos', 'Mensaje sobre SQL', '2023-01-02', true, 2, 102),
('Desarrollo Web', 'Mensaje sobre HTML', '2023-01-03', false, 3, 103),
('Programación en C', 'Mensaje sobre C', '2023-01-04', true, 4, 104),
('Python para Todos', 'Mensaje sobre Python', '2023-01-05', false, 5, 105),
('Machine Learning', 'Mensaje sobre ML', '2023-01-06', true, 6, 106),
('Introducción a Redes', 'Mensaje sobre Redes', '2023-01-07', true, 7, 107),
('Sistemas Operativos', 'Mensaje sobre SO', '2023-01-08', false, 8, 108),
('Seguridad Informática', 'Mensaje sobre Seguridad', '2023-01-09', true, 9, 109),
('Desarrollo de Software', 'Mensaje sobre Desarrollo', '2023-01-10', false, 10, 110);