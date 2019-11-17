package ru.levchenko.services;

import java.util.Map;

public interface AdminPageService {
    public void editUser(Map<String, String> form, Long id);
}
