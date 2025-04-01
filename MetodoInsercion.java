class MetodoInsercionFP {
    public void ordenar(int[] arreglo, boolean ascendente, boolean conPasos) {
        int comparaciones = 0;
        int cambios = 0;
        
        for (int i = 1; i < arreglo.length; i++) {
            int actual = arreglo[i];
            int j = i - 1;
            
            if (conPasos) {
                System.out.println("Elemento actual: " + actual);
            }
            
            while (j >= 0 && (ascendente ? arreglo[j] > actual : arreglo[j] < actual)) {
                comparaciones++;
                if (conPasos) {
                    System.out.println("Comparación " + (comparaciones) + ": " + arreglo[j] + 
                            (ascendente ? " > " : " < ") + actual);
                    System.out.println("Mover " + arreglo[j] + " a la derecha");
                }
                
                arreglo[j + 1] = arreglo[j];
                cambios++;
                j--;
                
                if (conPasos) {
                    System.out.println("Estado actual -> " + App.arrayToString(arreglo));
                }
            }
            
            if (j >= 0) {
                comparaciones++;
                if (conPasos) {
                    System.out.println("Comparación " + (comparaciones) + ": " + arreglo[j] + 
                            (ascendente ? " <= " : " >= ") + actual);
                }
            }
            
            arreglo[j + 1] = actual;
            cambios++;
            
            if (conPasos) {
                System.out.println("Insertar " + actual + " en posición " + (j + 1));
                System.out.println("Estado actual -> " + App.arrayToString(arreglo));
            }
        }
        
        if (!conPasos) {
            System.out.println("Comparaciones Totales -> " + comparaciones);
            System.out.println("Cambios Totales -> " + cambios);
        }
    }
}