databaseChangeLog() {
  changeSet(id:"my first changeset 2-25-2016", author:"bobby"){
    comment("Creating videos table")
    createTable(tableName:"videos"){
      column(name:"id", type:"int", autoIncrement:"true", incrementBy:"1"){
        constraints(primaryKey:true, nullable:false)
      }
      column(name: "video_name", type: "varchar(255)") {
        constraints(nullable: "false")
      }
      column(name: "added_by", type: "varchar(255)") {
        constraints(nullable: "false")
      }
      column(name: "date_added", type: "timestamp") {
        constraints(nullable: "false")
      }
      column(name: "language", type: "varchar(255)") {
        constraints(nullable: "false")
      }
      column(name: "video_location_path", type: "varchar(255)") {
        constraints(nullable: "false")
      }
    }
    rollback(){
      dropTable(tableName:"videos")
    }
  }
}