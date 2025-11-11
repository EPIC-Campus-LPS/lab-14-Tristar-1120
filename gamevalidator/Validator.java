package gamevalidator;

public class Validator {
	private static boolean ca;
	private static boolean b;
	private static boolean cr;
	private static boolean s;
	private static boolean d;

	public static boolean boardValidator(String[][] board) {
		// Check Board
		if (board.length != 10) {
			return false;
		} else {
			for (String[] i : board) {
				if (i.length != 10) {
					return false;
				}
			}
		}

		// Check Ships
		for (String[] i : board) {
			int col = -1;
			for (String j : i) {
				col++;
				switch (j) {
				case ("O"): {
					continue;
				}
				case ("0"): {
					continue;
				}
				case (null): {
					continue;
				}
				case ("C"): {
					if (ca == true) {
						return false;
					}
					int caCount = 0;
					// Check Row
					for (String k : i) {
						if (k == "C") {
							caCount++;
						}
						if (caCount != 5 && caCount != 1) {
							return false;
						} else if (caCount == 5) {
							// Remove Ship for clarity
							int found = 0;
							int rm = 0;
							while (found != 5) {
								if (i[rm] == "C") {
									i[rm] = null;
									found++;
								}
							}
							ca = true;
						} else {
							caCount = 0;
							// Check Column
							for (String[] l : board) {
								if (l[col] == "C") {
									caCount++;
								}
								if (caCount != 5) {
									return false;
								} else {
									int found = 0;
									int rm = 0;
									while (found != 5) {
										if (board[rm][col] == "C") {
											board[rm][col] = null;
											found++;
										}
										rm++;
									}
									ca = true;
								}
							}
						}
					}
				}
				case ("B"): {
					if (b == true) {
						return false;
					}
					int bCount = 0;
					// Check Row
					for (String k : i) {
						if (k == "B") {
							bCount++;
						}
						if (bCount != 4 && bCount != 1) {
							return false;
						} else if (bCount == 4) {
							// Remove Ship for clarity
							int found = 0;
							int rm = 0;
							while (found != 4) {
								if (i[rm] == "B") {
									i[rm] = null;
									found++;
								}
							}
							b = true;
						} else {
							bCount = 0;
							// Check Column
							for (String[] l : board) {
								if (l[col] == "B") {
									bCount++;
								}
								if (bCount != 4) {
									return false;
								} else {
									int found = 0;
									int rm = 0;
									while (found != 4) {
										if (board[rm][col] == "B") {
											board[rm][col] = null;
											found++;
										}
										rm++;
									}
									b = true;
								}
							}
						}
					}
				}
				case ("R"): {
					if (cr == true) {
						return false;
					}
					int rCount = 0;
					// Check Row
					for (String k : i) {
						if (k == "R") {
							rCount++;
						}
						if (rCount != 3 && rCount != 1) {
							return false;
						} else if (rCount == 3) {
							// Remove Ship for clarity
							int found = 0;
							int rm = 0;
							while (found != 3) {
								if (i[rm] == "R") {
									i[rm] = null;
									found++;
								}
							}
							cr = true;
						} else {
							rCount = 0;
							// Check Column
							for (String[] l : board) {
								if (l[col] == "R") {
									rCount++;
								}
								if (rCount != 3) {
									return false;
								} else {
									int found = 0;
									int rm = 0;
									while (found != 3) {
										if (board[rm][col] == "R") {
											board[rm][col] = null;
											found++;
										}
										rm++;
									}
									cr = true;
								}
							}
						}
					}
				}
				case ("S"): {
					if (s == true) {
						return false;
					}
					int sCount = 0;
					// Check Row
					for (String k : i) {
						if (k == "S") {
							sCount++;
						}
						if (sCount != 3 && sCount != 1) {
							return false;
						} else if (sCount == 5) {
							// Remove Ship for clarity
							int found = 0;
							int rm = 0;
							while (found != 3) {
								if (i[rm] == "S") {
									i[rm] = null;
									found++;
								}
							}
							s = true;
						} else {
							sCount = 0;
							// Check Column
							for (String[] l : board) {
								if (l[col] == "S") {
									sCount++;
								}
								if (sCount != 3) {
									return false;
								} else {
									int found = 0;
									int rm = 0;
									while (found != 3) {
										if (board[rm][col] == "S") {
											board[rm][col] = null;
											found++;
										}
										rm++;
									}
									s = true;
								}
							}
						}
					}
				}
				case ("D"): {
					if (d == true) {
						return false;
					}
					int dCount = 0;
					// Check Row
					for (String k : i) {
						if (k == "D") {
							dCount++;
						}
						if (dCount != 2 && dCount != 1) {
							return false;
						} else if (dCount == 5) {
							// Remove Ship for clarity
							int found = 0;
							int rm = 0;
							while (found != 2) {
								if (i[rm] == "D") {
									i[rm] = null;
									found++;
								}
							}
							d = true;
						} else {
							dCount = 0;
							// Check Column
							for (String[] l : board) {
								if (l[col] == "D") {
									dCount++;
								}
								if (dCount != 2) {
									return false;
								} else {
									int found = 0;
									int rm = 0;
									while (found != 2) {
										if (board[rm][col] == "D") {
											board[rm][col] = null;
											found++;
										}
										rm++;
									}
									d = true;
								}
							}
						}
					}
				}
				default:
					continue;
				}

			}
		}

		return true;

	}

		public static boolean balanced(String[][] board) {
		int col = 0;
		for (String[] row : board) {
			int rowCount = 0;
			String[] foundRow = new String[3];
			for (String item : row) {
				if (item != "0" && item != "O") {
					for (String found:foundRow) {
						if (found == item) {
							continue;
						}
						else {
							
						}
					}
					rowCount++;
				}
				if (rowCount > 2) {
					return false;
				}
			}
			int colCount = 0;
			if (row[col] != "0" && row[col] != "O") {
				colCount++;
			}
			if (colCount > 2) {
				return false;
			}
			col++;
		}

		return true;
	}

}
