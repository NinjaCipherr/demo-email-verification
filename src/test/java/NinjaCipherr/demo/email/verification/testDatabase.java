
package NinjaCipherr.demo.email.verification;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * testDatabase
 */
@SpringBootTest
public class testDatabase {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Test
    public void testConnection() {
        try {
            String sql = "SELECT 1"; // Truy vấn SQL đơn giản để kiểm tra kết nối
            Integer result = jdbcTemplate.queryForObject(sql, Integer.class);
            assertNotNull(result, "Kết quả không được null, chứng tỏ kết nối thành công.");
            System.out.println("Kết nối cơ sở dữ liệu thành công! Kết quả: " + result);
        } catch (Exception e) {
            e.printStackTrace();
            fail("Kết nối cơ sở dữ liệu không thành công: " + e.getMessage());
        }
    }
}
