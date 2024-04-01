package generics;

import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.Test;

class RoleStoreTest {

    @Test
    void whenAddAndFindThenRolenameIsSecurity() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "Security"));
        Role result = store.findById("1");
        assertThat(result.getRolename()).isEqualTo("Security");
    }

    @Test
    void whenAddAndFindThenRoleIsNull() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "Security"));
        Role result = store.findById("10");
        assertThat(result).isNull();
    }

    @Test
    void whenAddDuplicateAndFindRolenameIsSecurity() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "Security"));
        store.add(new Role("1", "Manager"));
        Role result = store.findById("1");
        assertThat(result.getRolename()).isEqualTo("Security");
    }

    @Test
    void whenReplaceThenRolenameIsManager() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "Security"));
        store.replace("1", new Role("1", "Manager"));
        Role result = store.findById("1");
        assertThat(result.getRolename()).isEqualTo("Manager");
    }

    @Test
    void whenNoReplaceRoleThenNoChangeRolename() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "Security"));
        store.replace("10", new Role("10", "Manager"));
        Role result = store.findById("1");
        assertThat(result.getRolename()).isEqualTo("Security");
    }

    @Test
    void whenDeleteRoleThenRoleIsNull() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "Security"));
        store.delete("1");
        Role result = store.findById("1");
        assertThat(result).isNull();
    }

    @Test
    void whenNoDeleteRoleThenRolenameIsSecurity() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "Security"));
        store.delete("10");
        Role result = store.findById("1");
        assertThat(result.getRolename()).isEqualTo("Security");
    }

    @Test
    void whenReplaceOkThenTrue() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "Security"));
        boolean result = store.replace("1", new Role("1", "Manager"));
        assertThat(result).isTrue();
    }

    @Test
    void whenReplaceNotOkThenFalse() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "Security"));
        boolean result = store.replace("10", new Role("10", "Manager"));
        assertThat(result).isFalse();
    }
}