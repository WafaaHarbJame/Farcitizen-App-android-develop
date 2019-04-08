package ms.messageapp;

        import com.google.gson.annotations.Expose;
        import com.google.gson.annotations.SerializedName;

public class Server {


        @SerializedName("id")
        @Expose
        private Integer id;
        @SerializedName("location")
        @Expose
        private String location;
        @SerializedName("home_server")
        @Expose
        private String homeServer;
        @SerializedName("id_server")
        @Expose
        private String idServer;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getLocation() {
            return location;
        }

        public void setLocation(String location) {
            this.location = location;
        }

        public String getHomeServer() {
            return homeServer;
        }

        public void setHomeServer(String homeServer) {
            this.homeServer = homeServer;
        }

        public String getIdServer() {
            return idServer;
        }

        public void setIdServer(String idServer) {
            this.idServer = idServer;
        }

    }
