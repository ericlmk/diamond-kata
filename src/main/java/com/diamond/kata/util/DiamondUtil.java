package com.diamond.kata.util;

public class DiamondUtil {

  /**
   * Validate the Char within the range A-Z
   * @return boolean result
   */
  public boolean isValidateChar(char endChar) {
    return (endChar<'A' || endChar>'Z');
  }

  /**
   * Draw the Diamond and return the result
   * @param endChar     the largest character to draw
   * @param emptyChar   the character to fill space
   * @return Diamond shape
   */
  public String draw(char endChar, char emptyChar) {
    // Validation
    if (this.isValidateChar(endChar)) {
      return "";  // How to handle?
    }

    StringBuilder sb = new StringBuilder();
    int charCount = endChar-'A'+1;
    int rowCount = (charCount-1) * 2 + 1;
    int midRow = charCount-1;
    for (int i=0; i<rowCount; i++) {

      // i<midRow means the upper side
      char c = (i<=midRow)? (char)('A'+i) : (char)('A'+rowCount-i-1);
      int sideCount = (i<=midRow)? (midRow-i) : (i-midRow);
      int midCount = (i<=midRow)? (i*2-1) : ((rowCount-i-1)*2-1);

      sb.append( String.valueOf(emptyChar).repeat(sideCount) );
      sb.append(c);
      if (midCount>0) {
        sb.append( String.valueOf(emptyChar).repeat(midCount) );
        sb.append(c);
      }
      sb.append( String.valueOf(emptyChar).repeat(sideCount) );

      if (i<rowCount-1) {
        sb.append("\r\n");  // If not last row
      }
    }
    return sb.toString();
  }

}
