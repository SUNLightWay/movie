package com.tech.movie.utils;

public class ConstUtil {
	
	//当前用户标识
	public static final String CUR_USER="curUser";
	
	//用户可以验证的信息
	public static final String TYPE_ACCOUNT="account";
	public static final String TYPE_EMAIL="email";
	public static final String TYPE_PHONE="phone";
	//图片文件上传路径
	public static final String UPLOAD_IMAGES_PATH="/upload/";
	

	/**
	 * 职位类型
	 * @author phineas
	 *
	 */
	public static class OccupationType{
        public static final int TYPE_OTHER = 0;
        public static final int TYPE_ACADEMIC = 1;
        public static final int TYPE_ARTIST = 2;
        public static final int TYPE_CLERICAL = 3;
        public static final int TYPE_COLLEGE = 4;
        public static final int TYPE_CUSTOMER = 5;
        public static final int TYPE_DOCTOR = 6;
        public static final int TYPE_EXECUTIVE = 7;
        public static final int TYPE_FARMER = 8;
        public static final int TYPE_HOMEMAKER = 9;
        public static final int TYPE_STUDENT = 10;
        public static final int TYPE_LAWYER = 11;
        public static final int TYPE_PROGRAMMER = 12;
        public static final int TYPE_RETIRED = 13;
        public static final int TYPE_SALES = 14;
        public static final int TYPE_SCIENTIST = 15;
        public static final int TYPE_SELFEMPLOYED = 16;
        public static final int TYPE_TECHNICIAN = 17;
        public static final int TYPE_TRADESMAN = 18;
        public static final int TYPE_UNEMPLOYED = 19;
        public static final int TYPE_WRITER = 20;


        public static String getUserType(int code){
        	String desc = "未知状态";
            switch (code){
                case TYPE_OTHER:
                    desc = "other or not specified";
                    break;
                case TYPE_ACADEMIC:
                    desc = "academic/educator";
                    break;
                case TYPE_ARTIST:
                    desc = "artist";
                    break;
                case TYPE_CLERICAL:
                    desc = "clerical/admin";
                    break;
                case TYPE_COLLEGE:
                    desc = "college/grad student";
                    break;
                case TYPE_CUSTOMER:
                    desc = "customer service";
                    break;
                case TYPE_DOCTOR:
                    desc = "doctor/health care";
                    break;
                case TYPE_EXECUTIVE:
                    desc = "executive/managerial";
                    break;
                case TYPE_FARMER:
                    desc = "farmer";
                    break;
                case TYPE_HOMEMAKER:
                    desc = "homemaker";
                    break;
                case TYPE_STUDENT:
                    desc = "K-12 student";
                    break;
                case TYPE_LAWYER:
                    desc = "lawyer";
                    break;
                case TYPE_PROGRAMMER:
                    desc = "programmer";
                    break;
                case TYPE_RETIRED:
                    desc = "retired";
                    break;
                case TYPE_SALES:
                    desc = "sales/marketing";
                    break;
                case TYPE_SCIENTIST:
                    desc = "scientist";
                    break;
                case TYPE_SELFEMPLOYED:
                    desc = "self-employed";
                    break;
                case TYPE_TECHNICIAN:
                    desc = "technician/engineer";
                    break;
                case TYPE_TRADESMAN:
                    desc = "tradesman/craftsman";
                    break;
                case TYPE_UNEMPLOYED:
                    desc = "unemployed";
                    break;
                case TYPE_WRITER:
                    desc = "writer";
                    break;
            }
            return desc;
        }
    }
	
	/**
	 * 性别类型
	 * @author phineas
	 *
	 */
	public static class SexType{
        public static final int SEX_MALE = 0;
        public static final int SEX_FEMALE = 1;

        public static String getUserType(int code){
        	String desc = "未知状态";
            switch (code){
                case SEX_MALE:
                    desc = "男";
                    break;
                case SEX_FEMALE:
                    desc = "女";
                    break;
            }
            return desc;
        }
    }

    /**
     * 用户类型类型
     * @author phineas
     *
     */
    public static class RoleType{
        public static final int ROLE_USER = 0;
        public static final int ROLE_ADMIN = 1;

        public static String getUserType(int code){
            String desc = "未知状态";
            switch (code){
                case ROLE_USER:
                    desc = "用户";
                    break;
                case ROLE_ADMIN:
                    desc = "管理员";
                    break;
            }
            return desc;
        }
    }

}
