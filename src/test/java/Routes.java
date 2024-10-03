public class Routes {

        /**
         10
         * The base uri is the resource where all the <b>services</b> are running.
         11
         */

    public static String base_uri  ="https://petstore.swagger.io/v2";

        /**
         14
         * The post uri route the request to a service to create an user.
         15
         */

    public static String post_uri  ="/user";

        /**

         * The get,put,delete uri routes the request to respective services
         19
         to read,update,delete an user using username.
         20
         */

    public static String get_put_delete_uri="/user/{username}";


}



