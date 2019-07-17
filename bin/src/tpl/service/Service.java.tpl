package {{ group }}.{{ module }}.api;

import {{ group }}.{{ module }}.dto.{{ Umodule }}Dto;

public interface {{ Umodule }}Service {
    {{ Umodule }}Dto get{{ Umodule }}(int id);
}
