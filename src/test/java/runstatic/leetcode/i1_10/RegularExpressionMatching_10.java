package runstatic.leetcode.i1_10;

import org.testng.Assert;
import org.testng.annotations.Test;
import runstatic.leetcode.annotation.TODO;

/**
 * @author chenmoand
 */
@TODO("写不出来。。哈哈哈")
public class RegularExpressionMatching_10 {

    public boolean isMatch(String s, String p) {
        final char[] sChars = s.toCharArray();
        final char[] pChars = p.toCharArray();

        int sLen = sChars.length, pLen = pChars.length;
        int sIndex = 0, pIndex = 0;

        while (true) {
            final boolean sCond = sIndex < sLen;
            final boolean pCond = pIndex >= pLen;
            if ((pCond && sCond)) {
                return false;
            }
            if (!sCond && !pCond) {
                if ((pLen - pIndex) % 2 == 0) {
                    int i = 2;
                    while (pIndex + i < pLen) {
                        if (pChars[pIndex + i] != '*') {
                            return false;
                        }
                        i += 2;
                    }
                    return true;
                }

                return false;
            }
            char sChr = sChars[sIndex];
            char pChr = pChars[pIndex];
            if (pIndex == pLen - 1) {
                if (pChr != '.') {
                    if (sChr == pChr) {
                        if (sIndex == sLen - 1) {
                            return true;
                        }
                        ++pIndex;
                        continue;
                    }
                    return false;
                } else {
                    if (sIndex == sLen - 1) {
                        return true;
                    }
                    ++pIndex;
                    continue;
                }
            }

            char pNextChr = pChars[pIndex + 1];
            if (pNextChr == '*') {
                if (pChr == '.') {
                    if (pIndex + 2 >= pLen) {
                        return true;
                    }
                    pNextChr = pChars[pIndex + 2];
                    int i = 0;
                    innerLoop:
                    while (sIndex + i < sLen) {
                        if (sChars[sIndex + i] != pNextChr) {
                            break innerLoop;
                        }
                        if (sIndex + i == sLen - 1) {
                            return true;
                        }
                        i++;
                    }
                    sIndex += i;
                    pIndex += 3;
                    continue;
                }
                if (sChr == pChr) {
                    int i = 0;
                    innerLoop:
                    while (sIndex + i < sLen) {
                        if (sChars[sIndex + i] != pChr) {
                            break innerLoop;
                        }
                        if (sIndex + i == sLen - 1) {
                            return true;
                        }
                        i++;
                    }
                    sIndex += i;
                }
                pIndex += 2;
                continue;
            }


            ++sIndex;
            ++pIndex;
        }
    }


    @Test
    public void isMatchTest() {
        Assert.assertTrue(isMatch("aa", "a.*"));
        Assert.assertTrue(isMatch("aab", "c*a*b"));

    }
}
