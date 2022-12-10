package aadikatyal.cs1331.hw3;

/**
 * I worked on the assignment alone, using only course-provided materials.
 *
 * @author Aadi Katyal
 */

import java.util.Scanner;

class Canvas {
	public static void main(String[] args) {
		int[][] canvas = new int[Integer.parseInt(args[0])][Integer.parseInt(args[1])];

		fill(canvas, getColor("#FFFFFF"));
		CanvasRenderer.setup(canvas.length, canvas[0].length);
		CanvasRenderer.render(canvas);

		Scanner scanner = new Scanner(System.in);

		while (true) {
			String input = scanner.nextLine();
			String arr[] = input.split(" ");

			if (arr[0].equalsIgnoreCase("QUIT")) {
				CanvasRenderer.close();
				scanner.close();
				break;
			} else if (arr[0].equalsIgnoreCase("SAVE")) {
				CanvasImageSave.save(canvas, arr[1]);
			} else {
				if (arr[0].equalsIgnoreCase("PIXEL")) {
					setPixelColor(canvas, Integer.parseInt(arr[1]), Integer.parseInt(arr[2]), getColor(arr[3]));
					CanvasRenderer.render(canvas);
				} else if (arr[0].equalsIgnoreCase("RECTANGLE")) {
					drawRectangle(canvas, Integer.parseInt(arr[1]), Integer.parseInt(arr[2]), Integer.parseInt(arr[3]),
							Integer.parseInt(arr[4]), getColor(arr[5]));
					CanvasRenderer.render(canvas);
				} else if (arr[0].equalsIgnoreCase("SQUARE")) {
					drawSquare(canvas, Integer.parseInt(arr[1]), Integer.parseInt(arr[2]), Integer.parseInt(arr[3]),
							getColor(arr[4]));
					CanvasRenderer.render(canvas);
				} else if (arr[0].equalsIgnoreCase("FILL")) {
					fill(canvas, getColor(arr[1]));
					CanvasRenderer.render(canvas);
				} else if (arr[0].equalsIgnoreCase("REPLACE")) {
					replaceColor(canvas, getColor(arr[1]), getColor(arr[2]));
					CanvasRenderer.render(canvas);
				} else if (arr[0].equalsIgnoreCase("GRID")) {
					boolean same = arr[4].equals("SAME") ? true : false;
					drawGrid(canvas, Integer.parseInt(arr[1]), Integer.parseInt(arr[2]), Integer.parseInt(arr[3]), same,
							getColor(arr[5]));
					CanvasRenderer.render(canvas);
				} else if (arr[0].equalsIgnoreCase("LOWER")) {
					drawLowerTriangle(canvas, Integer.parseInt(arr[1]), Integer.parseInt(arr[2]),
							Integer.parseInt(arr[3]), getColor(arr[4]));
					CanvasRenderer.render(canvas);
				} else if (arr[0].equalsIgnoreCase("UPPER")) {
					drawUpperTriangle(canvas, Integer.parseInt(arr[1]), Integer.parseInt(arr[2]),
							Integer.parseInt(arr[3]), getColor(arr[4]));
					CanvasRenderer.render(canvas);
				}
			}
		}
	}

	static int getColor(String color) {
		color = color.substring(1);
		return Integer.parseInt(color, 16);
	}

	static void setPixelColor(int[][] canvas, int row, int col, int color) {
		canvas[row][col] = color;
	}

	static void drawRectangle(int[][] canvas, int row, int col, int height, int width, int color) {
		for (int i = row; i < row + height; i++) {
			for (int j = col; j < col + width; j++) {
				canvas[i][j] = color;
			}
		}
	}

	static void drawSquare(int[][] canvas, int row, int col, int size, int color) {
		drawRectangle(canvas, row, col, size, size, color);
	}

	static void fill(int[][] canvas, int color) {
		drawRectangle(canvas, 0, 0, canvas.length, canvas[0].length, color);
	}

	static void replaceColor(int[][] canvas, int oldColor, int newColor) {
		for (int i = 0; i < canvas.length; i++) {
			for (int j = 0; j < canvas[0].length; j++) {
				if (canvas[i][j] == oldColor) {
					canvas[i][j] = newColor;
				}
			}
		}
	}

	static void drawGrid(int[][] canvas, int row, int col, int size, boolean same, int color) {
		for (int i = row; i < row + size; i++) {
			for (int j = col; j < col + size; j++) {
				if (same && ((i - row) % 2 == (j - col) % 2)) {
					canvas[i][j] = color;
				} else if (!same && ((i - row) % 2 != (j - col) % 2)) {
					canvas[i][j] = color;
					System.out.println("aadi");
				}
			}
		}
	}

	static void drawLowerTriangle(int[][] canvas, int row, int col, int size, int color) {
		int counter = 1;
		for (int i = row; i < row + size; i++) {
			for (int j = col; j < col + counter; j++) {
				canvas[i][j] = color;
			}
			counter++;
		}
	}

	static void drawUpperTriangle(int[][] canvas, int row, int col, int size, int color) {
		int counter = 0;
		for (int i = row; i < row + size; i++) {
			for (int j = col + counter; j < col + size; j++) {
				canvas[i][j] = color;
			}
			counter++;
		}
	}
}