public void CalculateArea(String shapeType, int side, int width) {
	// mengubah parameter int tipe menjadi string, 
	// merubah function dari calc menjadi calculate area
    int area = 0;

    
    //merubah nama variabel menjadi nama agar mudah dimengerti
    if (shapeType == "square) {
        
        area = side * side;
    } else if (shapeType == "rectangle") {
        area = side * width;
    } else if (shapeType == "circle") {
        area = 3.14 * side * side;
    }

    System.out.println("Area of " + shapeType + " : " + area);
}

class Main {
    public static void main(String[] args) {
\        int squareSide = 7;
        int rectangleWidth = 8;
        int rectangleHeight = 3;
        int circleRadius = 10;

\        CalculateArea("square", squareSide, 0);
        CalculateArea("rectangle", rectangleWidth, rectangleHeight);
        CalculateArea("circle", circleRadius, 0);
    }
}