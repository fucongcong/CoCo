include '{{ modulePrefix }}-{{ module }}'
include '{{ modulePrefix }}-{{ module }}:{{ modulePrefix }}-{{ module }}-service'
findProject(':{{ modulePrefix }}-{{ module }}:{{ modulePrefix }}-{{ module }}-service')?.name = '{{ modulePrefix }}-{{ module }}-service'
include '{{ modulePrefix }}-{{ module }}:{{ modulePrefix }}-{{ module }}-dao'
findProject(':{{ modulePrefix }}-{{ module }}:{{ modulePrefix }}-{{ module }}-dao')?.name = '{{ modulePrefix }}-{{ module }}-dao'
include '{{ modulePrefix }}-{{ module }}:{{ modulePrefix }}-{{ module }}-api'
findProject(':{{ modulePrefix }}-{{ module }}:{{ modulePrefix }}-{{ module }}-api')?.name = '{{ modulePrefix }}-{{ module }}-api'
