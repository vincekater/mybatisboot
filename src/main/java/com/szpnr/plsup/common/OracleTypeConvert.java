package com.szpnr.plsup.common;


import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.ITypeConvert;
import com.baomidou.mybatisplus.generator.config.rules.DbColumnType;
import com.baomidou.mybatisplus.generator.config.rules.IColumnType;

public class OracleTypeConvert implements ITypeConvert {
    public OracleTypeConvert() {
    }

    public IColumnType processTypeConvert(GlobalConfig globalConfig, String fieldType) {
        String t = fieldType.toLowerCase();
        //System.out.println(t);
        if (t.contains("char")) {
            return DbColumnType.STRING;
        } else {
            if (!t.contains("date") && !t.contains("timestamp")) {
                if (t.contains("number")) {
                    if (t.matches("number\\(+\\d\\)")) {
                        return DbColumnType.INTEGER;
                    }

                    if (t.matches("number\\(+\\d{2}+\\)")) {
                        return DbColumnType.LONG;
                    }
                    if (t.matches("number\\(+\\d{1,2}\\,\\d{1,2}\\)")) {
                        return DbColumnType.DOUBLE;
                    }
                    return DbColumnType.LONG;
                }

                if (t.contains("float")) {
                    return DbColumnType.FLOAT;
                }

                if (t.contains("clob")) {
                    return DbColumnType.CLOB;
                }

                if (t.contains("blob")) {
                    return DbColumnType.BLOB;
                }

                if (t.contains("binary")) {
                    return DbColumnType.BYTE_ARRAY;
                }

                if (t.contains("raw")) {
                    return DbColumnType.BYTE_ARRAY;
                }
            } else {
                switch(globalConfig.getDateType()) {
//                    case DATE_SQL:
//                        return DbColumnType.DATE_SQL;
                    case ONLY_DATE:
                        return DbColumnType.DATE_SQL;
                    case SQL_PACK:
                        return DbColumnType.TIMESTAMP;
                    case TIME_PACK:
                        return DbColumnType.LOCAL_DATE_TIME;
                }
            }

            return DbColumnType.STRING;
        }
    }
}