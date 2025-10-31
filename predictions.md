
1. Year Range Queries (very likely)
   java
   List<VehicleRegistration> findByYearRange(int startYear, int endYear)
   List<VehicleRegistration> findByYear(int year)


2. Registration Validation (likely)
   java
   // UK format: AB12 CDE, AB12CDE
   private boolean isValidUKRegistration(String regNumber) {
   return regNumber.matches("^[A-Z]{2}\\d{2}\\s?[A-Z]{3}$");
   }


Other likely requirements:

3. Search/Filter Operations
   java
   List<VehicleRegistration> findUnassignedRegistrations() // null vehicle IDs
   List<VehicleRegistration> findByVehicleId(String vehicleId)
   boolean exists(String registrationNumber)


4. Bulk Operations
   java
   void saveAll(List<VehicleRegistration> registrations)
   void removeAll(List<String> registrationNumbers)


5. Statistics/Reporting
   java
   Map<Integer, Integer> getRegistrationCountByYear()
   int getUnassignedCount()


6. Update Operations
   java
   void updateVehicleId(String regNumber, String newVehicleId)
   void assignVehicle(String regNumber, String vehicleId)


7. Data Import/Export
   java
   void loadFromFile(String filename)
   void exportToFile(String filename)

