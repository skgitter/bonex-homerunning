package com.bonex.sys.util;


/**
 * �X�g�����O���[�e�B���e�B�N���X
 */
public class StringUtil extends freemarker.template.utility.StringUtil {

	static public String formatDBTableName(String tableName) {
		String resultString = tableName.replaceAll("[A-Z]", "_$0");
		resultString = resultString.substring(1);
		return resultString.toUpperCase();
	}

    /**
     * �E����
     */
    public static final String RIGHT_KATU = ")";    
    
    /**
     * ������
     */
    public static final String LEFT_KATU = "(";
    
    /**
     * "-"
     */
    public static final String LINE = "-";
    
    /**
     * ���p�R���}
     */
    public static final String COMMA = ",";
        
    /**
     * ���p�X�y�[�X
     */
    public static final String SPACE = " ";

    /**
     * �S�p�X�y�[�X
     */
    public static final String ZENKAKU_SPACE = "　";
    
    /**
     * �S�p�X�y�[�X����
     */
    public static final char CHAR_ZENKAKU_SPACE = '　';
    
    /**
     * ���p�X�y�[�X����
     */
    public static final char CHAR_SPACE = ' ';
    
    /**
     * TAB����
     */
    public static final char CHAR_TAB = '\t'; 
    
    /**
     * �󕶎�
     */
    public static final String BLANK = "";
    
    /**
     * {%
     */
    public static final String STR_LEFTKAKKO = "{%";
    
    /**
     * UNDERLINE
     */
    public static final String UNDERLINE = "_";
    
    /** File DOT: . */
    public static final String DOT = ".";

    /**
     * WAVELINE
     */
    public static final String WAVELINE = "�`";

    /**
     * �s�Z�p���[�^�[
     */
    public static final String LINE_SEPARATOR = System
            .getProperty("line.separator");

    /**
     * �t�@�C���Z�p���[�^�[
     */
    public static final String FILE_SEPARATOR = System
            .getProperty("file.separator");

    /**
     * �p�X�Z�p���[�^�[
     */
    public static final String PATH_SEPARATOR = System
            .getProperty("path.separator");

    /**
     * ���p,
     */
    public static final String KANMA = ",";
    
    /**
     * �R����
     */
    public static final String COLON = ":";

    /**
     * �Z�~�R����
     */
    public static final String SEMICOLON = ";";

    /**
     * �V�X�e����
     */
    public static final String SYSNAME = "i*Standard";
    
    /**
     * ����
     */
    public static final String EQUALSIGN = "=";
    
    /**
     * �A���p�T���h
     */
    public static final String AMPERSAND = "&";
    
    /**
     * �ΐ�
     */
    public static final String OBLIQUELINE = "/";
    
    /**
     * ��ؐ�
     */
    public static final String SPLITLINE = ";";
    
    /** �p�[�Z���g */
    public static final String PERCENT = "%";
    
    /** �Ǔ_ */
    public static final String TOUTEN = "�A";

    /**
     * resultStr�̌�����len��薢���̏ꍇ�A�擪�Ɏw�蕶���𖄂ߍ���
     * @param resultStr �Ώە�����
     * @param len ����
     * @param str ����
     * @return ���ʕ�����
     */
    public static String padLeft(String resultStr, int len, char str) {
        
        String strObj = resultStr;
        if (null == strObj) {
            strObj = "";
        }
        
        StringBuffer buf = new StringBuffer(strObj);
        
        while (buf.length() < len) {
            buf.insert(0, str);
        }
        return buf.toString();
    }

    /**
     * resultStr�̌�����len��薢���̏ꍇ�A���Ɏw�蕶���𖄂ߍ���
     * @param resultStr �Ώە�����
     * @param len ����
     * @param str ����
     * @return ���ʕ�����
     */
    public static String padRight(String resultStr, int len, char str) {
        
        String strObj = resultStr;
        if (null == strObj) {
            strObj = "";
        }
        
        StringBuffer buf = new StringBuffer(strObj);
        
        while (buf.length() < len) {
            buf.append(str);
        }
        return buf.toString();
    }

    /**
     * �󕶎��񂩂ǂ����`�F�b�N
     * @param text �Ώە�����
     * @return boolean �`�F�b�N����
     */
    public static boolean isEmpty(String text) {
        if (null == text || text.length() == 0) {
            return true;
        }
        return false;
    }

    /**
     * �擪����A�w��o�C�g���̕������擾����.
     *
     * @param str ��������
     * @param len �w��o�C�g��
     * @return String �擾����������
     */
    public static String getSubString(String str, int len) {
        if (isEmpty(str)) {
            return BLANK;
        }

        if (0 >= len) {
            return str;
        }

        // �o�C�g������擾����
        final int byteLength = getByteLength(str);

        if (byteLength < len) {
            return str;
        }

        StringBuffer sb = new StringBuffer(str);
        sb.setLength(len);

        while (getByteLength(sb.toString()) > len) {
            sb.deleteCharAt(sb.length() - 1);
        }

        return sb.toString();
    }

    /**
     * ��͂���������̃o�C�g������擾����.
     *
     * @param str ��͂���������
     * @return �o�C�g����
     */
    public static int getByteLength(String str) {
        int len = 0;

        len = str.getBytes().length;

        return len;
    }

    /**
     * str��NULL�܂��͋󕶎��̏ꍇ�A�󕶎��㊃^�[���B
     * 
     * @param str ������
     * @return String ������܂��͋󕶎�
     */
    public static String nvl(String str) {
        if (isEmpty(str)) {
            return "";
        } else {
            return str;
        }
    }
    
    /**
     * �����͋󔒂��ǂ�����`�F�b�N����B
     * 
     * @param c ����
     * @return true ������͋󔒂ł���B false ������͋󔒂ł͂Ȃ��B
     */
    public static boolean isSpace(char c) {
        return c == CHAR_SPACE || c == CHAR_TAB || c == CHAR_ZENKAKU_SPACE;
    }

    /**
     * ������̑O��󔒂��B
     * 
     * @param s ������
     * @return String �ύX���ꂽ������B
     */
    public static String trim(String s) {

        if (s == null) {
            return null;
        }

        int begin = 0;
        int end = 0;
        int length = s.length();
        for (begin = 0; begin < length; begin++) {
            if (!isSpace(s.charAt(begin))) {
                break;
            }
        }

        for (end = length - 1; end >= 0; end--) {
            if (!isSpace(s.charAt(end))) {
                break;
            }
        }

        if (end < begin) {
            return "";

        }
        return s.substring(begin, end + 1);
    }
    
    /**
     * ������͋󔒂��ǂ�����`�F�b�N����B
     * 
     * @param s ������
     * @return true ������͋󔒂ł���B false ������͋󔒂ł͂Ȃ��B
     */
    public static boolean isSpace(String s) {
        if (s == null) {
            return false;
        }
        int length = s.length();
        for (int i = 0; i < length; i++) {
            if (!isSpace(s.charAt(i))) {
                return false;
            }
        }

        return true;
    }

    /**
     * ���b�Z�[�W�{���̃p�����[�^�z���_�Ƀp�����[�^�����ށB
     * @param params �p�����[�^
     * @param message ���b�Z�[�W�{��
     * @return formatMessage �ϊ��������b�Z�[�W
     */
    public static String formatMessage(String message, String...params) {
        
        if (params == null || params.length == 0) {
            return message;
        }
        StringBuffer buf = new StringBuffer();
        int leftPos = 0;
        int lastPos = 0;
        while ((leftPos = message.indexOf(STR_LEFTKAKKO, lastPos)) >= 0) {
            int rightPos = message.indexOf("}", leftPos);
            if (rightPos < 0) {
                break;
            } else {
                int nexLeftPos = message.indexOf(STR_LEFTKAKKO, leftPos + 2);
                if (rightPos > nexLeftPos && nexLeftPos > 0) {
                    buf.append(message.substring(lastPos, nexLeftPos));
                    lastPos = nexLeftPos;
                    continue;
                }
            }
            String sIdx = message.substring(leftPos + 2, rightPos);
            int nIdx = 0;
            try {
                nIdx = Integer.parseInt(sIdx);
            } catch (NumberFormatException e) {
                nIdx = Integer.MAX_VALUE;
            }
            if (nIdx > params.length) {
                buf.append(message.substring(lastPos, rightPos + 1));
                lastPos = rightPos + 1;
            } else {
                buf.append(message.substring(lastPos, leftPos));
                buf.append(params[nIdx - 1]);
                lastPos = rightPos + 1;
            }
        }      
        buf.append(message.substring(lastPos));
        return buf.toString();
    }

    /**
     * ��z�̓R���}��<br>
     * ��F�i999,999,999��999999999�j <br>
     *
     * @param amount ��z�i�R���}��܂ށj
     * @return String ��z(�R���}������܂���)
     */
    public static String trimAmountKonma(String amount) {

        if (null != amount) {
            return amount.replaceAll(",", "");
        }

        return null;
    }
    
    /**
     * �����N�t�B�[���h�ɑ΂��āA��s�R�[�h��S�p�X�y�[�X�ɒu������B
     * @param linkField �����N�t�B�[���h�̒l
     * @return String �ϊ����������N�t�B�[���h�̒l
     */
    public static String formatReportLinkField(String linkField) {

        if (isEmpty(linkField)) {
            return linkField;
        }
        // �f�[�^�̑S�p�X�y�[�X�𔼊p�X�y�[�X�Q�ɒu��
        linkField = linkField.replaceAll(ZENKAKU_SPACE, SPACE + SPACE);
        // ��s�R�[�h��S�p�X�y�[�X�ɒu��
        linkField = linkField.replaceAll(LINE_SEPARATOR, ZENKAKU_SPACE);

        return linkField;
    }
}