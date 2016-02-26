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
  
  changeSet( author: "bobby", id: "changeset 2-26-2016 10:27" ){
    comment("creating index's for columns")
    createIndex( indexName: "video_name_index", tableName: "videos", unique: "false" ) {
      column( name: "video_name" )
    }
    createIndex( indexName: "added_by_index", tableName: "videos", unique: "false" ) {
      column( name: "added_by" )
    }
    createIndex( indexName: "date_added_index", tableName: "videos", unique: "false" ) {
      column( name: "date_added" )
    }
    createIndex( indexName: "language_index", tableName: "videos", unique: "false" ) {
      column( name: "language" )
    }
  }
}